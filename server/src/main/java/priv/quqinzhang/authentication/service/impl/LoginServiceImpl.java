package priv.quqinzhang.authentication.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import priv.quqinzhang.authentication.common.enums.LoginStateEnum;
import priv.quqinzhang.authentication.common.enums.TokenSecretEnum;
import priv.quqinzhang.authentication.common.factory.BoFactory;
import priv.quqinzhang.authentication.common.throwable.ParameterEmptyException;
import priv.quqinzhang.authentication.common.throwable.TokenIncorrectException;
import priv.quqinzhang.authentication.common.throwable.UserNotFoundException;
import priv.quqinzhang.authentication.dto.in.UserLoginInDTO;
import priv.quqinzhang.authentication.dto.out.LoginStatusInfoOutDTO;
import priv.quqinzhang.authentication.entities.QUserEntity;
import priv.quqinzhang.authentication.entities.UserEntity;
import priv.quqinzhang.authentication.service.LoginService;

import java.util.Calendar;


/**
 * @author Quqin Zhang
 * @date 2019/12/26 22:04
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {

    private BoFactory boFactory;

    private JPAQueryFactory jpaQueryFactory;

    @Override
    public LoginStatusInfoOutDTO login(UserLoginInDTO userLoginInDTO) throws UserNotFoundException, TokenIncorrectException, ParameterEmptyException {


        if (StringUtils.isEmpty(userLoginInDTO.getUsername())) {
            throw new ParameterEmptyException("username");
        }

        if (StringUtils.isEmpty(userLoginInDTO.getPwd())) {
            throw new ParameterEmptyException("pwd");
        }

        QUserEntity qUserEntity = QUserEntity.userEntity;
        UserEntity userEntity = jpaQueryFactory.selectFrom(qUserEntity)
                .where(qUserEntity.username.eq(userLoginInDTO.getUsername())).fetchOne();
        if (userEntity == null) {
            throw new UserNotFoundException(userLoginInDTO.getUsername());
        }
        if (userLoginInDTO.getPwd().equals(userEntity.getPwd())) {

            LoginStatusInfoOutDTO statusInfoOutDTO = new LoginStatusInfoOutDTO();

            Algorithm algorithmHS = Algorithm.HMAC256(TokenSecretEnum.COMMON_SECRET.getSecret());

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE,30);
            String token = JWT.create()
                    .withExpiresAt(calendar.getTime())
                    .withIssuer("zqq")
                    .withClaim("username", userEntity.getUsername())
                    .sign(algorithmHS);
            statusInfoOutDTO.setLoginState(LoginStateEnum.SUCCESS);
            statusInfoOutDTO.setUsername(userEntity.getUsername());
            statusInfoOutDTO.setToken(token);
            return statusInfoOutDTO;
        }
        throw new TokenIncorrectException("认证凭证无效");
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MINUTE,30);
        System.out.println(calendar.getTime());
    }

    @Autowired
    public void setJpaQueryFactory(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Autowired
    public void setBoFactory(BoFactory boFactory) {
        this.boFactory = boFactory;
    }
}

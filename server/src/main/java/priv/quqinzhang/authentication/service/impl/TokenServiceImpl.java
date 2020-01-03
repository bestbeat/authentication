package priv.quqinzhang.authentication.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import priv.quqinzhang.authentication.common.enums.TokenSecretEnum;
import priv.quqinzhang.authentication.common.throwable.TokenIncorrectException;
import priv.quqinzhang.authentication.dto.in.TokenInDTO;
import priv.quqinzhang.authentication.dto.out.TokenValidateOutDTO;
import priv.quqinzhang.authentication.service.TokenService;

import java.util.Calendar;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 15:36
 * @description
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    @Override
    public TokenValidateOutDTO validate(TokenInDTO tokenInDTO) throws TokenIncorrectException {

        Algorithm algorithmHS = Algorithm.HMAC256(TokenSecretEnum.COMMON_SECRET.getSecret());
        String token = tokenInDTO.getToken();
        try {
            JWTVerifier verifier = JWT.require(algorithmHS)
                    .withIssuer("zqq")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            log.info(String.format("%s parse token",jwt.getClaim("username")));
            Boolean refresh = tokenInDTO.getRefresh();

            if (refresh) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MINUTE,30);
                token = JWT.create()
                        .withExpiresAt(calendar.getTime())
                        .withIssuer("zqq")
                        .withClaim("username", jwt.getClaim("username").asString())
                        .sign(algorithmHS);

            }
            TokenValidateOutDTO validateOutDTO = new TokenValidateOutDTO();
            validateOutDTO.setToken(token);
            return validateOutDTO;
        } catch (JWTVerificationException e) {
            log.error(e.getMessage());
            throw new TokenIncorrectException("令牌校验失败");
        }



    }
}

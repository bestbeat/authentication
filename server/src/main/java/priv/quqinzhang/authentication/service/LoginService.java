package priv.quqinzhang.authentication.service;

import priv.quqinzhang.authentication.common.throwable.ParameterEmptyException;
import priv.quqinzhang.authentication.common.throwable.TokenIncorrectException;
import priv.quqinzhang.authentication.common.throwable.UserNotFoundException;
import priv.quqinzhang.authentication.dto.in.UserLoginInDTO;
import priv.quqinzhang.authentication.dto.out.LoginStatusInfoOutDTO;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 21:44
 * @description 登录服务
 */
public interface LoginService {

    /**
     * 用户登录访问
     * @param userInDTO 用户登录信息
     * @return LoginStatusInfoOutDTO 用户登录结果
     * @throws UserNotFoundException 用户不存在
     * @throws TokenIncorrectException 凭证无效
     * @throws ParameterEmptyException 参数为空
     */
    LoginStatusInfoOutDTO login(UserLoginInDTO userInDTO) throws UserNotFoundException, TokenIncorrectException, ParameterEmptyException;

}

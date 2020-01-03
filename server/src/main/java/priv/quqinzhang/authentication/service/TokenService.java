package priv.quqinzhang.authentication.service;

import priv.quqinzhang.authentication.common.throwable.TokenIncorrectException;
import priv.quqinzhang.authentication.dto.in.TokenInDTO;
import priv.quqinzhang.authentication.dto.out.TokenValidateOutDTO;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 15:24
 * @description 令牌服务
 */
public interface TokenService {

    /**
     * 验证令牌
     * @param tokenInDTO 令牌信息
     * @return TokenValidateOutDTO 验证情况
     * @throws TokenIncorrectException 令牌无效
     */
    TokenValidateOutDTO validate(TokenInDTO tokenInDTO) throws TokenIncorrectException;

}

package priv.quqinzhang.authentication.common.throwable;

import lombok.Getter;
import priv.quqinzhang.authentication.enums.ResponseCodeEnum;

/**
 * @author Quqin Zhang
 * @date 2019/12/31 22:26
 * @description
 */
@Getter
public class TokenIncorrectException extends BaseException {

    public TokenIncorrectException(String exceptionMsg) {
        super(ResponseCodeEnum.TOKEN_INCORRECT,exceptionMsg);
    }

}

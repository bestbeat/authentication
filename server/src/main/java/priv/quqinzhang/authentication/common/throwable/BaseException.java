package priv.quqinzhang.authentication.common.throwable;

import lombok.Getter;
import priv.quqinzhang.authentication.enums.ResponseCodeEnum;

/**
 * @author Quqin Zhang
 * @date 2019/12/31 21:59
 * @description 自定义异常基础类
 */
@Getter
public abstract class BaseException extends Exception {

    private ResponseCodeEnum responseCodeEnum;

    private String exceptionMsg;

    public BaseException(ResponseCodeEnum responseCodeEnum, String exceptionMsg) {
        super(exceptionMsg);
        this.responseCodeEnum = responseCodeEnum;
        this.exceptionMsg = exceptionMsg;
    }

    public BaseException(ResponseCodeEnum responseCodeEnum, String exceptionMsg, Throwable cause) {
        super(exceptionMsg, cause);
        this.responseCodeEnum = responseCodeEnum;
        this.exceptionMsg = exceptionMsg;
    }

}

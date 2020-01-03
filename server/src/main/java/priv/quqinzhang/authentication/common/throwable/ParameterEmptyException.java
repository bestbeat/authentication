package priv.quqinzhang.authentication.common.throwable;

import lombok.Getter;
import priv.quqinzhang.authentication.enums.ResponseCodeEnum;

/**
 * @author Quqin Zhang
 * @date 2019/12/31 22:33
 * @description
 */
@Getter
public class ParameterEmptyException extends BaseException {

    private String paramName;

    public ParameterEmptyException(String paramName) {
        super(ResponseCodeEnum.PARAM_EMPTY,null);
        this.paramName = paramName;
    }

}

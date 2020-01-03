package priv.quqinzhang.authentication.common.throwable;

import lombok.Getter;
import priv.quqinzhang.authentication.enums.ResponseCodeEnum;

/**
 * @author Quqin Zhang
 * @date 2019/12/31 21:51
 * @description 用户不存在异常
 */
@Getter
public class UserNotFoundException extends BaseException {

    private String username;

    public UserNotFoundException(String username) {
        super(ResponseCodeEnum.USER_NOT_FOUND, null);
        this.username = username;
    }
}

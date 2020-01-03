package priv.quqinzhang.authentication.common.enums;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 21:55
 * @description 登录状态枚举
 */
public enum LoginStateEnum {

    /**
     * 登录成功
     */
    SUCCESS("登陆成功"),

    /**
     * 登录失败
     */
    FAIL("登录失败"),

    /**
     * 用户不存在
     */
    USER_NOT_FOUND("用户不存在"),

    /**
     * 密码不正确
     */
    PASSWORD_INCORRECT("密码不正确"),

    /**
     * 有效登录过期
     */
    LOGIN_EXPIRE("登录过期")

    ;


    private String msg;
    LoginStateEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}

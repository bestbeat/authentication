package priv.quqinzhang.authentication.enums;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 21:01
 * @description 响应编码
 */
public enum ResponseCodeEnum {

    /**
     * 普通-请求成功
     */
    SUCCESS("请求成功"),
    /**
     * 普通-请求失败
     */
    ERROR("请求失败"),

    /**
     * 请求参数错误
     */
    REQUEST_PARAM_ERROR("请求参数错误"),


    // 异常枚举

    /**
     * 参数为空
     */
    PARAM_EMPTY("参数为空"),

    /**
     * 用户不存在
     */
    USER_NOT_FOUND("用户不存在"),

    /**
     * 凭证不正确
     */
    TOKEN_INCORRECT("凭证不正确"),

    /**
     * 系统错误
     * 所有没有规定的错误类型都归系统错误
     */
    SYSTEM_ERROR("系统错误");

    private String msg;
    ResponseCodeEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}

package priv.quqinzhang.authentication.model;

import lombok.Data;
import priv.quqinzhang.authentication.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 20:58
 * @description 响应结果模型
 */
@Data
public class ResponseModel<T> implements Serializable {

    private ResponseCodeEnum code;

    private String msg;

    private T data;

    private ResponseModel(ResponseCodeEnum code, T data) {
        this.code = code;
        this.msg = code.getMsg();
        this.data = data;
    }

    private ResponseModel(ResponseCodeEnum code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseModel<T> response(ResponseCodeEnum code,String msg, T data) {
        return new ResponseModel<>(code,msg, data);
    }

    public static <T> ResponseModel<T> success(T data) {
        return new ResponseModel<>(ResponseCodeEnum.SUCCESS, data);
    }

    public static <T> ResponseModel<T> error(ResponseCodeEnum code, String msg) {
        return new ResponseModel<>(code, msg, null);
    }

    public static <T> ResponseModel<T> error(ResponseCodeEnum code) {
        return new ResponseModel<>(code, null);
    }

    public static <T> ResponseModel<T> systemError() {
        return new ResponseModel<>(ResponseCodeEnum.SYSTEM_ERROR, null);
    }

}

package priv.quqinzhang.authentication.dto.in;

import lombok.Data;

/**
 * @author Quqin Zhang
 * @date 2019/12/29 11:43
 * @description 用户登录数据传输
 */
@Data
public class UserLoginInDTO {

    private String username;

    private String pwd;

}

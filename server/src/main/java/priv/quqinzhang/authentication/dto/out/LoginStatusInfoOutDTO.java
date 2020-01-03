package priv.quqinzhang.authentication.dto.out;

import lombok.Data;
import priv.quqinzhang.authentication.common.enums.LoginStateEnum;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 21:52
 * @description 用户输出类
 */
@Data
public class LoginStatusInfoOutDTO {

    private String username;

    private LoginStateEnum loginState;

    private String token;

}

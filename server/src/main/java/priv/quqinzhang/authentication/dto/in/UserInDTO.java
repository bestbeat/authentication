package priv.quqinzhang.authentication.dto.in;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 21:36
 * @description 用户数据传入
 */
@Data
public class UserInDTO {

    private Long id;

    private String userId;

    private String username;

    private String mobilePhone;

    private String email;

    private String pwd;

    private String createManName;

    private String createMan;

    private String updateManName;

    private String updateMan;

}

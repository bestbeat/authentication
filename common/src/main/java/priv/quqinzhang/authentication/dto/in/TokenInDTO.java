package priv.quqinzhang.authentication.dto.in;

import lombok.Data;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 15:29
 * @description 令牌信息传入
 */
@Data
public class TokenInDTO {

    private String token;

    private Boolean refresh;

}

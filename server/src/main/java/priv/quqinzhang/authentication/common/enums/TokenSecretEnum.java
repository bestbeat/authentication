package priv.quqinzhang.authentication.common.enums;

import lombok.Getter;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 15:51
 * @description 令牌密钥
 */
@Getter
public enum TokenSecretEnum {

    /**
     * 常用密钥
     */
    COMMON_SECRET("Authentication")
    ;

    private String secret;

    TokenSecretEnum(String secret){
        this.secret = secret;
    }
}

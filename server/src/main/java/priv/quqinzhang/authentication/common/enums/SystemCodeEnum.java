package priv.quqinzhang.authentication.common.enums;

import lombok.Getter;

/**
 * @author Quqin Zhang
 * @date 2019/12/30 20:12
 * @description 系统编号枚举, 三位系统编码
 */
@Getter
public enum SystemCodeEnum {

    /**
     * 测试系统
     */
    TEST("000", "测试系统")
    ;
    private String code;
    private String name;
    SystemCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

}

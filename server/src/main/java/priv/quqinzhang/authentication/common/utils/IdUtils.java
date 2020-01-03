package priv.quqinzhang.authentication.common.utils;

import priv.quqinzhang.authentication.common.enums.SystemCodeEnum;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Quqin Zhang
 * @date 2019/12/30 19:44
 * @description Id生成器
 */
public class IdUtils {


    /**
     * 生成用户Id
     * 由13位时间戳 + 6 位随机数字 + 2 位预留(00) + 3位 systemCode
     * @param systemCode 系统编码 代表某个系统
     * @return userId
     */
    public static String createUserId(SystemCodeEnum systemCode){
        Long timeStamp = Instant.now().toEpochMilli();
        Long random = ThreadLocalRandom.current().nextLong(1000000);
        StringBuffer retVal = new StringBuffer(24);
        retVal.append(timeStamp);
        retVal.append(random);
        retVal.append("00");
        retVal.append(systemCode.getCode());
        return retVal.toString();
    }

    public static void main(String[] args) {
        System.out.println(IdUtils.createUserId(SystemCodeEnum.TEST));
    }
}

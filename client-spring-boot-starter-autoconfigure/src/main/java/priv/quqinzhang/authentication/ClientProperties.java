package priv.quqinzhang.authentication;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 19:20
 * @description 权限系统配置参数类
 */
@ConfigurationProperties(prefix = "authentication")
@Data
public class ClientProperties {

    private String serverUrl;

    private Set<String> urlPatterns;

}

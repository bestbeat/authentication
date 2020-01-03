package priv.quqinzhang.authentication;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author Quqin Zhang
 * @date 2020/1/3 20:11
 * @description 认证客户端自动配置类
 */
@Configuration
@ConditionalOnClass
@EnableConfigurationProperties(ClientProperties.class)
public class AuthenticationClientAutoConfiguration {

    private ClientProperties properties;

    public AuthenticationClientAutoConfiguration(ClientProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> authenticationClientFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        AuthenticationClientFilter filter = new AuthenticationClientFilter();
        AuthenticationClient authenticationClient = new AuthenticationClient();
        filter.setClient(authenticationClient);
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setUrlPatterns(properties.getUrlPatterns());
        return filterRegistrationBean;
    }

}

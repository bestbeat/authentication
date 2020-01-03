package priv.quqinzhang.authentication.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @author Quqin Zhang
 * @date 2019/12/26 22:29
 * @description
 */
@Component
public class AppContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object getBean(String name) {
        return this.applicationContext.getBean(name);
    }

    public <T> T getBean(Class<T> requiredType) {
        return this.applicationContext.getBean(requiredType);
    }

}

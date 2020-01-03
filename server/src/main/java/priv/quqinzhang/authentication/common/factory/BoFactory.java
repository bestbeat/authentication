package priv.quqinzhang.authentication.common.factory;

import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import priv.quqinzhang.authentication.config.AppContext;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Quqin Zhang
 * @date 2019/12/26 22:22
 * @description BO 域 工厂
 */
@Component
public class BoFactory {

    private AppContext appContext;

    @Autowired
    public BoFactory(AppContext appContext) {
        this.appContext = appContext;
    }

    public<T> T getBO(@NotNull Class<T> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Field[] fields = clazz.getDeclaredFields();
        T obj = clazz.newInstance();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            if (fieldName.endsWith("Repository") || fieldName.endsWith("Factory")) {
                Method method = clazz.getMethod(StringFormatter.format("set%s%s",
                        fieldName.substring(0,1).toUpperCase(),
                        fieldName.substring(1)).get(),field.getType());
                Object parameter = appContext.getBean(field.getType());
                method.invoke(obj,parameter);
            }

        }

        return obj;
    }

}

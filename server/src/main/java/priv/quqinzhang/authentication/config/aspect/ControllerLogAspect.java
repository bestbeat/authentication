package priv.quqinzhang.authentication.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Quqin Zhang
 * @date 2019/12/28 12:04
 * @description 控制器日志切面
 */
@Component
@Aspect
@Slf4j
public class ControllerLogAspect {

    @Pointcut("execution(public * priv.quqinzhang.authentication.controller..*.*(..))")
    public void controllerMethod(){}


    @Around("controllerMethod()")
    public Object  aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        log.info("{} {} {}",request.getMethod(), request.getRequestURL().toString(), request.getProtocol());
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        String[] params = signature.getParameterNames();

        StringBuffer buffer = new StringBuffer();
        buffer.append("RequestParams:{ ");
        for (int i = 0; i< params.length; i++) {
            buffer.append(params[i]);
            buffer.append("={}, ");
        }
        buffer.append("} ");
        Object[] values = proceedingJoinPoint.getArgs();
        log.info(buffer.toString(),values);

        String methodName = proceedingJoinPoint.getSignature().getName();

        try{
            Object retVal = proceedingJoinPoint.proceed();
            log.info("Method: {}, Return: {}",methodName,retVal);

            return retVal;
        } catch (Throwable throwable) {
            log.info("Method: {} - error: {}",proceedingJoinPoint.getSignature().getName(), throwable.getMessage());
        }

        return null;

    }

}

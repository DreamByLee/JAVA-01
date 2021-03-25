package io.lee.rpcfx.demo.consumer.aspect;

import io.lee.rpcfx.annotation.Service;
import io.lee.rpcfx.client.Rpcfx;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author Leeyj
 * @date 2021/3/25 21:54
 */
@Component
@Aspect
public class ServiceAspect {
    @Before("execution(* io.lee.rpcfx.demo.consumer.controller.*.*(..))")
    public void requestLimit(JoinPoint joinPoint) throws Exception {
        Object target = joinPoint.getTarget();
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Service service = field.getAnnotation(Service.class);
            if (service != null) {
                //判断当前字段是否为空
                if (field.get(target) == null) {
                    //生成代理对象
                    field.set(target, Rpcfx.create(field.getType(), service.hostUrl()));
                }
            }
        }
    }
}

package org.week07.sourceV1.annotation;

import java.lang.annotation.*;

/**
 * 动态数据源注解
 * @author Leeyj
 * @date 2021/3/12 21:18
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    /**
     * 数据源key值
     * @return
     */
    String value();
}

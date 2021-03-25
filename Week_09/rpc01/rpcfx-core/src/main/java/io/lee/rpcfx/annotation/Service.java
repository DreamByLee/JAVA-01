package io.lee.rpcfx.annotation;

public @interface Service {
    String hostUrl() default "";
}

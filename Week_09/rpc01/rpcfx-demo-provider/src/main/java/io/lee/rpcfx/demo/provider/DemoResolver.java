package io.lee.rpcfx.demo.provider;

import io.lee.rpcfx.api.RpcfxResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DemoResolver implements RpcfxResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(Class<?> serviceClass) {
        return this.applicationContext.getBean(serviceClass);
    }
}

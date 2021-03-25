package io.lee.rpcfx.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.lee.rpcfx.api.*;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Leeyj
 * @date 2021/3/25 22:41
 */
public class RpcfxByteBuddy {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.lee");
    }

    public static <T> T create(final Class<T> serviceClass, final String url, Filter... filters) {
        try {
            return (T) new ByteBuddy()
                    .subclass(Object.class)
                    .implement(serviceClass)
                    .intercept(InvocationHandlerAdapter.of(new RpcfxByteBuddy.RpcfxBytebuddyInterceptor(serviceClass, url)))
                    .make()
                    .load(serviceClass.getClassLoader())
                    .getLoaded()
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) new Object();

    }

    public static class RpcfxBytebuddyInterceptor implements InvocationHandler {

        private final Class<?> serviceClass;
        private final String url;
        private final Filter[] filters;

        public <T> RpcfxBytebuddyInterceptor(Class<T> serviceClass, String url, Filter... filters) {
            this.serviceClass = serviceClass;
            this.url = url;
            this.filters = filters;
        }

        // 可以尝试，自己去写对象序列化，二进制还是文本的，，，rpcfx是xml自定义序列化、反序列化，json: code.google.com/p/rpcfx
        // int byte char float double long bool
        // [], data class

        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
            RpcfxRequest request = new RpcfxRequest();
            request.setServiceClass(this.serviceClass);
            request.setMethod(method.getName());
            request.setParams(params);
            RpcfxResponse response = new NettyClientImpl().post(request, this.url);
            return JSON.parse(response.getResult().toString());
        }
    }
}

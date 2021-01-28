package io.github.leeyj.gatewayPart2.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HttpResponseFilterImpl implements HttpResponseFilter {
    @Override
    public void responseFilter(FullHttpResponse response) {
        response.headers().set("response", "hello responseFilter");
    }
}

package io.github.leeyj.gatewayPart2.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpRequestFilterImpl implements HttpRequestFilter {
    @Override
    public void requestFilter(FullHttpRequest request, ChannelHandlerContext context) {
        request.headers().set("request", "hello requestFilter");
    }
}

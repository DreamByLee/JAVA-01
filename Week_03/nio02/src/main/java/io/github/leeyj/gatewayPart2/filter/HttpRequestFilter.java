package io.github.leeyj.gatewayPart2.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter {

    void requestFilter(FullHttpRequest request, ChannelHandlerContext context);
}

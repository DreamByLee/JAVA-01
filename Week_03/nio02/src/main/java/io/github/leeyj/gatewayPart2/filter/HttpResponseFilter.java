package io.github.leeyj.gatewayPart2.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {

    void responseFilter(FullHttpResponse response);
}

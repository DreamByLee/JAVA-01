package io.lee.rpcfx.netty;

import io.lee.rpcfx.api.RpcfxRequest;
import io.lee.rpcfx.api.RpcfxResponse;

import java.io.IOException;

public interface NettyClient {
    public RpcfxResponse post(RpcfxRequest request, String url) throws IOException;

}

package io.lee.rpcfx.api;

import io.lee.rpcfx.exception.RpcfxException;
import lombok.Data;

@Data
public class RpcfxResponse {
    private Object result;
    private boolean status;
    private RpcfxException exception;
}

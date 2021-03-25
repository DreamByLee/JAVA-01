package io.lee.rpcfx.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Leeyj
 * @date 2021/3/25 17:56
 */

@Data
@AllArgsConstructor
@ToString
public class RunRpcfxException extends Exception{
    public String message;

    public Integer code;
}

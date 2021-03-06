package io.lee.rpcfx.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Leeyj
 * @date 2021/3/25 17:45
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RpcfxException {

    public String message;

    public Integer code;
}

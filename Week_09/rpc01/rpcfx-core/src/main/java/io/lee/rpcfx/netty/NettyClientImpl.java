package io.lee.rpcfx.netty;

import com.alibaba.fastjson.JSON;
import io.lee.rpcfx.api.RpcfxRequest;
import io.lee.rpcfx.api.RpcfxResponse;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import static org.asynchttpclient.Dsl.*;

/**
 * @author Leeyj
 * @date 2021/3/25 22:26
 */
public class NettyClientImpl implements NettyClient {
    @Override
    public RpcfxResponse post(RpcfxRequest request, String url) throws IOException {
        AsyncHttpClient asyncHttpClient = asyncHttpClient();
        Request httpRequest = org.asynchttpclient.Dsl.post(url)
                .setHeaders(new DefaultHttpHeaders().set("Content-Type", "application/json;charset=UTF-8"))
                .setBody(JSON.toJSONString(request)).build();

        Future<Response> whenResponse = asyncHttpClient.executeRequest(httpRequest);

        RpcfxResponse rpcfxResponse = new RpcfxResponse();
        Response response = null;
        try {
            response = whenResponse.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            rpcfxResponse.setStatus(false);
            rpcfxResponse.setResult(null);
            rpcfxResponse.setException(e);

            return rpcfxResponse;
        }
        asyncHttpClient.close();
        return JSON.parseObject(response.getResponseBody(), RpcfxResponse.class);
    }
}

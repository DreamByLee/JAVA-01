package io.github.leeyj.gatewayPart2.inbound;

import io.github.leeyj.gatewayPart2.filter.HttpRequestFilter;
import io.github.leeyj.gatewayPart2.filter.HttpRequestFilterImpl;
import io.github.leeyj.gatewayPart2.outbound.OutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

public class InboundHandler extends ChannelInboundHandlerAdapter {

    private final String proxyServer;
    private OutboundHandler outboundHandler;
    private HttpRequestFilter requestFilter = new HttpRequestFilterImpl();

    public InboundHandler(String proxyServer) {
        this.proxyServer = proxyServer;
        this.outboundHandler = new OutboundHandler(proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            outboundHandler.handle(fullRequest,ctx,requestFilter);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
        super.channelRead(ctx, msg);
    }
}

package io.github.leeyj.gatewayPart2.inbound;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.List;

public class InboundInit extends ChannelInitializer {

    private String proxyServer;

    public InboundInit(String proxyServer) {
        this.proxyServer = proxyServer;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {

        ChannelPipeline p = channel.pipeline();
        p.addLast(new HttpServerCodec());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new InboundHandler(this.proxyServer));
    }
}

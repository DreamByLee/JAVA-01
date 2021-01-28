package io.github.leeyj;


import io.github.leeyj.gatewayPart2.inbound.InboundServer;

public class NettyServerApplication {
    
    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "2.0.0";

    public static void main(String[] args) {

        String proxyPort = System.getProperty("proxyPort","8888");

        // 这是之前的单个后端url的例子
        String proxyServer = System.getProperty("proxyServer","http://localhost:8801");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        InboundServer server = new InboundServer(port, proxyServer);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

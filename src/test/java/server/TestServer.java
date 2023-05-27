package server;

import org.example.IDL.Hello.HelloService;
import org.example.IDL.Ping.PingService;
import org.example.core.server.RpcServer;

public class TestServer {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        HelloService helloService = new HelloServiceImpl(); // 包含需要处理的方法的对象
        rpcServer.register(helloService); // 向rpc server注册对象里面的所有方法
//        PingService pingService = new PingServiceImpl();
//        rpcServer.register(pingService);

        rpcServer.serve(9000);
    }
}

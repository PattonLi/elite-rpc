package org.example.core.client;

import org.example.core.protocol.RpcRequest;
import org.example.core.protocol.RpcResponse;
import org.example.core.codec.RpcRequestBody;
import org.example.core.codec.RpcResponseBody;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcClientProxy implements InvocationHandler {

    public <T> T getService(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class<?>[]{clazz},
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 1、将调用所需信息编码成bytes[]，调用编码【codec层】
        RpcRequestBody rpcRequestBody = new RpcRequestBody();
        rpcRequestBody.setInterfaceName(method.getDeclaringClass().getName());
        rpcRequestBody.setMethodName(method.getName());
        rpcRequestBody.setParamTypes(method.getParameterTypes());
        rpcRequestBody.setParameters(args);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(rpcRequestBody);
        byte[] bytes = baos.toByteArray();

        // 2、创建RPC协议对象，封装Header、Body内容【protocol层】
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setHeader("version=1");
        rpcRequest.setBody(bytes);

        // 3、发送RpcRequest，获得RpcResponse
        RpcClientTransfer rpcClient = new RpcClientTransfer();
        RpcResponse rpcResponse = rpcClient.sendRequest(rpcRequest);

        // 4、解析RpcResponse，也就是在解析rpc协议【protocol层】
        String header = rpcResponse.getHeader();
        byte[] body = rpcResponse.getBody();
        if (header.equals("version=1")) {
            // 将RpcResponse的body中的返回编码，解码成我们需要的对象Object并返回【codec层】
            ByteArrayInputStream bais = new ByteArrayInputStream(body);
            ObjectInputStream ois = new ObjectInputStream(bais);
            RpcResponseBody rpcResponseBody = (RpcResponseBody) ois.readObject();
            Object retObject = rpcResponseBody.getRetObject();
            return retObject;
        }
        return null;
    }
}

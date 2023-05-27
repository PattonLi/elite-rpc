package org.example.IDL.Hello;

//定义的接口文件，可被调用的方法
public interface HelloService {
    HelloResponse hello(HelloRequest request);
    HelloResponse hi(HelloRequest request);
}


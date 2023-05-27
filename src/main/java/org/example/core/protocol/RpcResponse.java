package org.example.core.protocol;

import java.io.Serializable;


// 为什么要有泛型？因为返回的对象是各种各样类型的
// Serializable：对象变成可传输的字节序列
public class RpcResponse implements Serializable {
    // 协议头部分
    private String header;

    // 协议体部分
    private byte[] body;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}


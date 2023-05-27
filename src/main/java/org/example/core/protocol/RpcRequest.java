package org.example.core.protocol;

import java.io.Serializable;


// Serializable：对象变成可传输的字节序列
public class RpcRequest implements Serializable {
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


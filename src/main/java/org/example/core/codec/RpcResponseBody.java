package org.example.core.codec;

import java.io.Serializable;


// 返回值编码
public class RpcResponseBody implements Serializable {
    private Object retObject;

    public Object getRetObject() {
        return retObject;
    }

    public void setRetObject(Object retObject) {
        this.retObject = retObject;
    }
}

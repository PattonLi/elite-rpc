package org.example.IDL.Ping;

import java.io.Serializable;


public class PingResponse implements Serializable {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PingResponse(String msg) {
        this.msg = msg;
    }
}
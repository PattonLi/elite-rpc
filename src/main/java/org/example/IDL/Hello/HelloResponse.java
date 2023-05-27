package org.example.IDL.Hello;

import java.io.Serializable;


public class HelloResponse implements Serializable {
    private String msg;

    public HelloResponse(String msg) {
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
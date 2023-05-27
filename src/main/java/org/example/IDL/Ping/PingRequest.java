package org.example.IDL.Ping;

import java.io.Serializable;


public class PingRequest implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

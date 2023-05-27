package org.example.IDL.Hello;

import java.io.Serializable;


public class HelloRequest implements Serializable {
    private String name;

    public HelloRequest(String name) {
        this.name = name;
    }

    public HelloRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

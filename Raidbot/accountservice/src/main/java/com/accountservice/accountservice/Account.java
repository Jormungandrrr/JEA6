package com.accountservice.accountservice;

import java.io.Serializable;

public class Account implements Serializable {

    String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

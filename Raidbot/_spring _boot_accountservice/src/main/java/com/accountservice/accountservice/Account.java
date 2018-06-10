package com.accountservice.accountservice;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
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

package com.shiraz.librarymanagement.domain;

import lombok.Data;

@Data
public abstract class Account {

    protected String name;
    protected String email;
    protected String password;
    protected boolean status;
}

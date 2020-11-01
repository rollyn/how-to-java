package com.wisphil.service;

public abstract class Banking {

    public abstract boolean withdraw();
    public abstract boolean deposit();

    void diplayAccount() {
        System.out.println("Displaying account");
    }

}

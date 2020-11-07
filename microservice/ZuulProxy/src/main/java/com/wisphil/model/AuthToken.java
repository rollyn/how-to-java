package com.wisphil.model;

import java.io.Serializable;

public class AuthToken implements Serializable {

    private final String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

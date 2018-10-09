package com.github.oauth2.server.pojo;

public class Payer {

    private String email;
    public Payer(){}
    public Payer(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

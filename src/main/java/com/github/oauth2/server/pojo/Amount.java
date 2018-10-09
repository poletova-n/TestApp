package com.github.oauth2.server.pojo;

import java.util.Currency;

public class Amount {

    private String value;
    private String currency;
    public Amount(){}
    //If one of these methods throw exception - we have invalid amount


    public String getValue() {
        return value;
    }

    public void setValue(String value) throws InvalidAmountException{
        if (value.length() > 10) {
            throw new InvalidAmountException();
        }
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) throws InvalidAmountException {
        if (Currency.getInstance(currency) != null) {
            this.currency = currency;
        } else {
            throw new InvalidAmountException();
        }
    }
}



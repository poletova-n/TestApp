package com.github.oauth2.server.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Webhook {

    @Column
    String currency;

    @Column
    String amount;

    @Column
    int payment_id;

    @Column
    String external_id;

    @Column
    State status;

    @Column
    String sha2;

    Webhook(){}

    public Webhook(String curr, String amount, int pay_id, String external_id, State state, String sha2){
        this.currency = curr;
        this.amount = amount;
        this.payment_id = pay_id;
        this.external_id = external_id;
        this.status = state;
        this.sha2 = sha2;

    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    public String getSha2() {
        return sha2;
    }

    public void setSha2(String sha2) {
        this.sha2 = sha2;
    }

}

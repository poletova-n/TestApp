package com.github.oauth2.server.pojo;


import org.hibernate.Transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Record {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String intent;

    @Column
    private String notification_url;

    @Column
    private Payer payer;

    @Column
    private TransactionDetails transaction;

    public Record(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public TransactionDetails getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDetails transaction) {
        this.transaction = transaction;
    }


    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getNotification_url() {
        return notification_url;
    }

    public void setNotification_url(String notification_url) {
        this.notification_url = notification_url;
    }
}

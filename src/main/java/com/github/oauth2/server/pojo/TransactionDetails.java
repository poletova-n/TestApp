package com.github.oauth2.server.pojo;

public class TransactionDetails {

    private String external_id;
    private Amount amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private  String description;

    public TransactionDetails(){}

    public TransactionDetails( String externalId, Amount amount){
        this.external_id = externalId;
        this.amount = amount;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String externalId) {
        this.external_id = externalId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}

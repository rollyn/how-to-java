package com.wisphil.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public class Account implements Serializable {

    private String accountID;
    private Double amount;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

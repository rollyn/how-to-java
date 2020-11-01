package com.wisphil.model;

public class SavingAccount extends Account {

    private Double interest = 0.005d;

    public void setAccountID(String accountID) {
        super.setAccountID("ACC"+accountID);
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }
}

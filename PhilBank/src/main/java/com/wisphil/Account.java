package com.wisphil;

public class Account {

    //TODO: declare integer balance
    //      declare integer previous transaction
    //      declare string customer name
    //      declare string customer id

    //Class constructor
    Account(String customerName, String customerID) {
        //TODO: set customer name
        //TODO: set customer id
    }

    //Function for Depositing money
    void deposit(int amount) {
        //TODO: check if amount is not equal to zero
        //      increment balance
        //      set previous transaction with the aount
    }

    //Function for Withdrawing money
    void withdraw(int amount) {
        //TODO: check if amount is not equal to zero
        //      decrement balance
        //      set previous transaction with the negative aount
    }

    //Function showing the previous transaction
    void getPreviousTransaction() {
        //TODO: check previous transaction is greater than zero, display "Deposited: <previos transaction value>
        //      check previous transaction is less than zero, display "Withdrawn: <previos transaction value>
        //      if  previous transaction is zero display "No transaction occurred"
    }

    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        //double newBalance = (balance * interestRate * years) + balance;
        //TODO: display "The current interest rate is " and interest rate in percentage
        //TODO: display  "After " + years + " years, you balance will be: " + newBalance
    }
}

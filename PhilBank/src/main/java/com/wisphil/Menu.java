package com.wisphil;

import java.util.Scanner;

public class Menu {

    private Account account;

    public Menu(Account account) {
        //TODO: set account
    }

    void show() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        //TODO: display "Welcome <customer name>! "
        //TODO: display "Your ID is <customer id>"
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        //TODO: do a loop, exit if value entered is F
        //      A - display balance
        //      B - ask for an integer amount, tnen execute the account deposit passing the amount
        //      C - ask for an integer amount, tnen execute the account withdraw passing the amount
        //      D - display the previous transaction
        //      E - display "Enter how many years of accrued interest: ", then ask for years, then execute calculate interest
        //      If invalid selection display "Error: invalid option. Please enter A, B, C, D, or E or access services."

        //TODO: display "Thank you for banking with us!"
    }
}

package com.softserve.academy.homework.maksym.L2;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accNum, double balance){
        this.accountNumber = accNum;
        this.balance = balance;
    }


    public void deposit(double depositAmount) { //add paremeter in method
        this.balance += depositAmount;
    }

    public void withdraw(double withdrawAmount) { //add paremeter in method
        this.balance -= withdrawAmount;
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

package com.softserve.academy.homework.class3;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double sum) {//add paremeter in method
        balance += sum;//TODO
    }

    public void withdraw(double sum) {//add paremeter in method
        if (sum <= balance) {
            balance -= sum;
        } else {
            System.out.println("Insufficient funds");
        }
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

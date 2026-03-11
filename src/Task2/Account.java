package Task2;

import java.util.*;

public class Account {

    private static int nextAccountNumber = 1001;

    private int accountNumber;
    private double balance;
    private List<String> transactions;

    public Account(double initialBalance) {

        if(initialBalance < 0){
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = nextAccountNumber++;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();

        transactions.add("Account created with balance: " + initialBalance);
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){

        if(amount <= 0){
            System.out.println("Invalid amount");
            return;
        }

        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException{

        if(amount <= 0){
            System.out.println("Invalid amount");
            return;
        }

        if(amount > balance){
            throw new InsufficientFundsException("Insufficient balance");
        }

        balance -= amount;
        transactions.add("Withdrawn: " + amount);
    }

    public void showTransactions(){

        System.out.println("Transaction History:");

        for(String t : transactions){
            System.out.println(t);
        }
    }
}
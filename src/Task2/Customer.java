package Task2;

import java.util.*;

public class Customer {

    private String name;
    private String address;
    private List<Account> accounts;

    public Customer(String name, String address){

        this.name = name;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public void showCustomerDetails(){

        System.out.println("Customer Name: " + name);
        System.out.println("Address: " + address);

        System.out.println("Accounts:");

        if(accounts.isEmpty()){
            System.out.println("No accounts found.");
            return;
        }

        for(Account acc : accounts){

            System.out.println("Account Number: " + acc.getAccountNumber() +
                    " Balance: " + acc.getBalance());
        }
    }

    public Account findAccount(int accountNumber){

        for(Account acc : accounts){
            if(acc.getAccountNumber() == accountNumber){
                return acc;
            }
        }

        return null;
    }
}
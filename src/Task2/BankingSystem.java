package Task2;

import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Customer customer = new Customer("Siva", "Chennai");

        int choice;

        do{

            System.out.println("\n---- Banking Menu ----");
            System.out.println("1 Create New Account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 Transaction History");
            System.out.println("5 Customer Details");
            System.out.println("0 Exit");

            System.out.print("Enter option: ");

            choice = sc.nextInt();

            try{

                switch(choice){

                    case 1:

                        System.out.print("Enter initial balance: ");
                        double balance = sc.nextDouble();

                        Account newAcc = new SavingsAccount(balance);

                        customer.addAccount(newAcc);

                        System.out.println("Account created successfully!");
                        System.out.println("Account Number: " + newAcc.getAccountNumber());

                        break;

                    case 2:

                        System.out.print("Enter account number: ");
                        int depAcc = sc.nextInt();

                        Account acc1 = customer.findAccount(depAcc);

                        if(acc1 != null){

                            System.out.print("Enter deposit amount: ");
                            acc1.deposit(sc.nextDouble());

                        }else{
                            System.out.println("Account not found");
                        }

                        break;

                    case 3:

                        System.out.print("Enter account number: ");
                        int wdAcc = sc.nextInt();

                        Account acc2 = customer.findAccount(wdAcc);

                        if(acc2 != null){

                            System.out.print("Enter withdraw amount: ");
                            acc2.withdraw(sc.nextDouble());

                        }else{
                            System.out.println("Account not found");
                        }

                        break;

                    case 4:

                        System.out.print("Enter account number: ");
                        int trAcc = sc.nextInt();

                        Account acc3 = customer.findAccount(trAcc);

                        if(acc3 != null){
                            acc3.showTransactions();
                        }else{
                            System.out.println("Account not found");
                        }

                        break;

                    case 5:

                        customer.showCustomerDetails();

                        break;
                }

            }catch(InsufficientFundsException e){
                System.out.println(e.getMessage());
            }

        }while(choice != 0);

        sc.close();

        System.out.println("Banking System Closed");
    }
}
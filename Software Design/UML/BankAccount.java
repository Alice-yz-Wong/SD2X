package Software Design;

public abstract class BankAccount {
    protected double balance;
    protected String accountID;
    protected Customer accountOwner;

    public void open(double initialBalance){
        balance=initialBalance;
    }

    public void withdraw(double amount){
        balance=balance-amount;
    }

    public void deposit(double amount){
        balance=balance+amount;
    }



    
}

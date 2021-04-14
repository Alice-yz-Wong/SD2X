public class MyThread1 extends Thread {
    private BankAccount account;
    public MyThread1(BankAccount account){
        this.account=account;
    }

    public void run(){
        account.setBalance(100);
    }
}

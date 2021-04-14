public class BankAccount {
    public static final int NULL_ARGUMENT=-1;
    public static final int NEGATIVE_BALANCE=-2;
    public static final int SUCCESS=0;
    
    //arror code
    public int transfer(BankAccount other, double amount){
        if(other==null){
            return NULL_ARGUMENT;
        }else if(this.balance<0){
            return NEGATIVE_BALANCE;
        }
        this.deposit(amount);
        other.withdraw(amount);
        return BankAccount.SUCCESS;
    }

    //unchecked exceptions
    public void transfer2(BankAccount other, double amount){
        if(other==null){
            throw new IllegalArgumentException("bankaccount is null");
        }else if(this.balance<0){
            throw new IllegalArgumentException("balance is negative");
        }
        this.deposit(amount);
        other.withdraw(amount);
    }

    //check exceptions
    public void transfer3(BankAccount other, double amount){
        throws NullArgumentException, NegativeBalanceException{
            if(other==null){
                throw new NullArgumentException();
            }else if(this.balance<0){
                throw new NegativeBalanceException();
            }
        }
        this.deposit(amount);
        other.withdraw(amount);
    }

    //assertion
    public void transfer4(BankAccount other, double amount){
        assert other !=null;
        assert this.balance>=0;

        this.deposit(amount);
        other.withdraw(amount);

    }

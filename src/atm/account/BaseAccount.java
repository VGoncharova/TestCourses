package atm.account;

public abstract class BaseAccount implements IAccount{
    protected int balance;

    public BaseAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

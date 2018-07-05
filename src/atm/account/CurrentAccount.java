package atm.account;

public class CurrentAccount extends BaseAccount {

    public CurrentAccount(int balance) {
        super(balance);
    }

    @Override
    public void changeBalance(int amount) {
        balance += amount;
    }
}

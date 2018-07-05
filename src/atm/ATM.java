package atm;

import atm.account.CurrentAccount;
import atm.account.IAccount;

public class ATM {
    private IAccount currentAccount;

    public ATM() {
        currentAccount = new CurrentAccount(50000);
    }

    public void putMoney(int amount) {
        currentAccount.changeBalance(amount);
    }

    public void giveMoney(int amount) {
        currentAccount.changeBalance(-amount);
    }

    public int getBalance() {
        return currentAccount.getBalance();
    }
}

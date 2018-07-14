package ATMadvanced.model.money;

import ATMadvanced.model.money.Money;

public interface MoneyInterface {
    void addMoney(Money money);
    Money getMoney(double balanceLess);
    Money getMoneyWithoutLess();
}

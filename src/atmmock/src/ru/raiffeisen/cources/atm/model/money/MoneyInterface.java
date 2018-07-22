package atmmock.src.ru.raiffeisen.cources.atm.model.money;

import atmmock.src.ru.raiffeisen.cources.atm.model.money.Money;

public interface MoneyInterface {
    void addMoney(Money money);
    Money getMoney(double balanceLess);
    Money getMoneyWithoutLess();
}

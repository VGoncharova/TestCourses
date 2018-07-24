package atmmock.src.ru.raiffeisen.cources.atm.model.score;

import atmmock.src.ru.raiffeisen.cources.atm.model.account.Account;
import atmmock.src.ru.raiffeisen.cources.atm.model.money.Money;

@Loggable
public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    @Override
    public void addMoney(Money money){
        super.addMoney(money);
    }

    @Override
    public Money getMoney(double balanceLess){
        return super.getMoney(balanceLess);
    }

    @Override
    public Money getMoneyWithoutLess(){
        return super.getMoneyWithoutLess();
    }

    @Override
    public boolean checkBefore(Money money) {
        return super.checkBefore(money);
    }
}

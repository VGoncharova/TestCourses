package ATMadvanced.model.score;

import ATMadvanced.Loggable;
import ATMadvanced.model.account.Account;
import ATMadvanced.model.money.Money;
import ATMadvanced.model.money.MoneyInterface;

@Loggable
public abstract class Score implements MoneyInterface {
   private Money balance;
   private Account owner;
   private Integer number;

    public Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (balance != null ? !balance.equals(score.balance) : score.balance != null) return false;
        if (owner != null ? !owner.equals(score.owner) : score.owner != null) return false;
        return number != null ? number.equals(score.number) : score.number == null;
    }

    @Override
    public int hashCode() {
        int result = balance != null ? balance.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Score{" +
                "balance=" + balance +
                ", owner=" + owner +
                ", number=" + number +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public void addMoney(Money money){
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
        double usdValueThis = this.balance.getValue() * this.balance.getCurrency().getUsdCource();

        if(usdValueThis < usdValueIn) {
            System.out.println("You have no so much!");
            return;
        }

        if(checkBefore()) {
            this.balance.setValue((usdValueThis + usdValueIn) * this.balance.getCurrency().getUsdCource());
        } else {
            System.out.println("No check!");
            return;
        }
    }

    @Override
    public Money getMoney(double balanceLess){
        if(balanceLess > 30000) {
            throw new IllegalArgumentException("Wrong balance less!");
        }

        this.balance.setValue(this.balance.getValue() - balanceLess);

        return this.balance;
    }

    @Override
    public Money getMoneyWithoutLess(){
        return this.balance;
    }

    abstract boolean checkBefore();
}

package ATMadvanced.model.money;

import ATMadvanced.annotations.OperationLimit;
import ATMadvanced.model.constants.CurrencyHolder;

@OperationLimit(limit = 100000)
public class Money {
    private Currency currency;
    private double value;

    public Money(double value, String currencyName) {
        this.value = value;
        this.currency = CurrencyHolder.getCurrencyByName(currencyName);
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

package atmmock.src.ru.raiffeisen.cources.atm;

import atmmock.src.ru.raiffeisen.cources.atm.model.constants.CurrencyHolder;
import atmmock.src.ru.raiffeisen.cources.atm.model.money.Money;
import atmmock.src.ru.raiffeisen.cources.atm.model.score.CreditScore;
import atmmock.src.ru.raiffeisen.cources.atm.model.score.CurrentScore;
import atmmock.src.ru.raiffeisen.cources.atm.model.score.DebetScore;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ATMTest {
    private static ATM atm;

    public ATMTest() {
        CreditScore creditScore =
                new CreditScore(
                        new Money(0.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1);
        DebetScore debetScore =
                new DebetScore(
                        new Money(0.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, creditScore);
        CurrentScore currentScore =
                new CurrentScore(
                        new Money(0.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, debetScore);
        atm = new ATM(currentScore, debetScore, creditScore);
    }

    @Before
    public void fillData() {
        Money moneyCredit = new Money(1000, "RUR");
        setMoneyToCredit(moneyCredit);
        Money moneyDebet = new Money(1000, "RUR");
        setMoneyToDebet(moneyDebet);
        Money moneyCurrent = new Money(1000, "RUR");
        setMoneyToCurrent(moneyCurrent);
    }

    @Test
    public void addMoneyToScorePositive() {
        Money moneyCredit = new Money(100, "RUR");
        atm.addMoneyToScore(moneyCredit, ScoreTypeEnum.CREDIT);
        Money moneyNewCredit = getMoneyFromCredit();
        Assert.assertEquals(1100, moneyNewCredit.getValue(), 0.000001);

        Money moneyDebet = new Money(100, "RUR");
        atm.addMoneyToScore(moneyDebet, ScoreTypeEnum.DEBET);
        Money moneyNewDebet = getMoneyFromDebet();
        Assert.assertEquals(1100, moneyNewDebet.getValue(), 0.000001);

        Money moneyCurrent = new Money(100, "RUR");
        atm.addMoneyToScore(moneyCurrent, ScoreTypeEnum.CURRENT);
        Money moneyNewCurrent = getMoneyFromCurrent();
        Assert.assertEquals(1100, moneyNewCurrent.getValue(), 0.000001);
    }

    @Test
    public void getMoneyFromScorePositive() {
        Money moneyCredit = new Money(100, "RUR");
        atm.getMoneyFromScore(moneyCredit, ScoreTypeEnum.CREDIT);
        Money moneyNewCredit = getMoneyFromCredit();
        Assert.assertEquals(900, moneyNewCredit.getValue(), 0.000001);

        Money moneyDebet = new Money(100, "RUR");
        atm.getMoneyFromScore(moneyDebet, ScoreTypeEnum.DEBET);
        Money moneyNewDebet = getMoneyFromDebet();
        Assert.assertEquals(900, moneyNewDebet.getValue(), 0.000001);

        Money moneyCurrent = new Money(100, "RUR");
        atm.getMoneyFromScore(moneyCurrent, ScoreTypeEnum.CURRENT);
        Money moneyNewCurrent = getMoneyFromCurrent();
        Assert.assertEquals(900, moneyNewCurrent.getValue(), 0.000001);
    }

    @Test
    public void addMoneyToScoreNegative() {

        Money moneyNegativeCredit = new Money(-100, "RUR");
        boolean exceptionWereCredit = false;
        try {
            atm.addMoneyToScore(moneyNegativeCredit, ScoreTypeEnum.CREDIT);
        } catch (IllegalArgumentException ex) {
            exceptionWereCredit = true;
        }

        Money moneyNegativeDebet = new Money(-100, "RUR");
        boolean exceptionWereDebet = false;
        try {
            atm.addMoneyToScore(moneyNegativeDebet, ScoreTypeEnum.DEBET);
        } catch (IllegalArgumentException ex) {
            exceptionWereDebet = true;
        }

        Money moneyNegativeCurrent = new Money(-100, "RUR");
        boolean exceptionWereCurrent = false;
        try {
            atm.addMoneyToScore(moneyNegativeCurrent, ScoreTypeEnum.CURRENT);
        } catch (IllegalArgumentException ex) {
            exceptionWereCurrent = true;
        }

        assertTrue(exceptionWereCredit);
        assertTrue(exceptionWereDebet);
        assertTrue(exceptionWereCurrent);
    }

    @Test
    public void getMoneyFromScoreNegative() {

        Money moneyNegativeCredit = new Money(-100, "RUR");
        boolean exceptionWereCredit = false;
        try {
            atm.getMoneyFromScore(moneyNegativeCredit, ScoreTypeEnum.CREDIT);
        } catch (IllegalArgumentException ex) {
            exceptionWereCredit = true;
        }

        Money moneyNegativeDebet = new Money(-100, "RUR");
        boolean exceptionWereDebet = false;
        try {
            atm.getMoneyFromScore(moneyNegativeDebet, ScoreTypeEnum.DEBET);
        } catch (IllegalArgumentException ex) {
            exceptionWereDebet = true;
        }

        Money moneyNegativeCurrent = new Money(-100, "RUR");
        boolean exceptionWereCurrent = false;
        try {
            atm.getMoneyFromScore(moneyNegativeCurrent, ScoreTypeEnum.CURRENT);
        } catch (IllegalArgumentException ex) {
            exceptionWereCurrent = true;
        }

        assertTrue(exceptionWereCredit);
        assertTrue(exceptionWereDebet);
        assertTrue(exceptionWereCurrent);
    }

    @Test
    public void addMoneyToScoreTooLargeAmountAtOnce() {
        Money moneyCredit = new Money(31000, "RUR");
        boolean exceptionWereCredit = false;
        try {
            atm.getMoneyFromScore(moneyCredit, ScoreTypeEnum.CREDIT);
        } catch (IllegalArgumentException ex) {
            exceptionWereCredit = true;
        }
        assertTrue(exceptionWereCredit);

        Money moneyDebet = new Money(31000, "RUR");
        boolean exceptionWereDebet = false;
        try {
            atm.getMoneyFromScore(moneyDebet, ScoreTypeEnum.DEBET);
        } catch (IllegalArgumentException ex) {
            exceptionWereDebet = true;
        }
        assertTrue(exceptionWereDebet);

        Money moneyCurrent = new Money(31000, "RUR");
        boolean exceptionWereCurrent = false;
        try {
            atm.getMoneyFromScore(moneyCurrent, ScoreTypeEnum.CURRENT);
        } catch (IllegalArgumentException ex) {
            exceptionWereCurrent = true;
        }
        assertTrue(exceptionWereCurrent);
    }

    @Test
    public void creditScoreUnderLimitDebetScoreForbidden() {
        Money moneyCredit = new Money(-21000, "RUR");
        setMoneyToCredit(moneyCredit);
        Money moneyDebet = new Money(100, "RUR");
        atm.getMoneyFromScore(moneyDebet, ScoreTypeEnum.DEBET);
        Money moneyNewDebet = getMoneyFromDebet();
        Assert.assertEquals(1000, moneyNewDebet.getValue(), 0.000001);

    }

    @Test
    public void addMoneyToDebetScoreIfOnCurrentPutMoreThenMln() {
        Money moneyCurrent = new Money(1001000, "RUR");
        atm.addMoneyToScore(moneyCurrent, ScoreTypeEnum.CURRENT);
        Money moneyNewCurrent = getMoneyFromCurrent();
        Assert.assertEquals(1002000, moneyNewCurrent.getValue(), 0.000001);
        Money moneyNewDebet = getMoneyFromCurrent();
        Assert.assertEquals(3000, moneyNewDebet.getValue(), 0.000001);
    }

    @After
    public void cleanData() {
        Money money = new Money(0, "RUR");
        setMoneyToCredit(money);
    }



    private Money getMoneyFromCredit() {
        Money money = null;

        Class atmClass = atm.getClass();
        try {
            Field creditScoreField = atmClass.getDeclaredField("creditScore");
            creditScoreField.setAccessible(true);

            CreditScore creditScore = (CreditScore) creditScoreField.get(atm);
            Class scoreClass = creditScore.getClass().getSuperclass();

            Field moneyField = scoreClass.getDeclaredField("balance");
            moneyField.setAccessible(true);

            money = (Money) moneyField.get(creditScore);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return money;
    }

    private Money getMoneyFromDebet() {
        Money money = null;

        Class atmClass = atm.getClass();
        try {
            Field debetScoreField = atmClass.getDeclaredField("debetScore");
            debetScoreField.setAccessible(true);

            DebetScore debetScore = (DebetScore) debetScoreField.get(atm);
            Class scoreClass = debetScore.getClass().getSuperclass();

            Field moneyField = scoreClass.getDeclaredField("balance");
            moneyField.setAccessible(true);

            money = (Money) moneyField.get(debetScore);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return money;
    }

    private Money getMoneyFromCurrent() {
        Money money = null;

        Class atmClass = atm.getClass();
        try {
            Field currentScoreField = atmClass.getDeclaredField("currentScore");
            currentScoreField.setAccessible(true);

            CurrentScore currentScore = (CurrentScore) currentScoreField.get(atm);
            Class scoreClass = currentScore.getClass().getSuperclass();

            Field moneyField = scoreClass.getDeclaredField("balance");
            moneyField.setAccessible(true);

            money = (Money) moneyField.get(currentScore);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return money;
    }

    private void setMoneyToCredit(Money money) {
        Class atmClass = atm.getClass();
        try {
            Field creditScoreField = atmClass.getDeclaredField("creditScore");
            creditScoreField.setAccessible(true);

            CreditScore creditScore = (CreditScore) creditScoreField.get(atm);
            Class scoreClass = creditScore.getClass().getSuperclass();

            Field moneyField = scoreClass.getDeclaredField("balance");
            moneyField.setAccessible(true);
            moneyField.set(creditScore, money);

            creditScoreField.set(atm, creditScore);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void setMoneyToDebet(Money money) {
        Class atmClass = atm.getClass();
        try {
            Field debetScoreField = atmClass.getDeclaredField("debetScore");
            debetScoreField.setAccessible(true);

            DebetScore debetScore = (DebetScore) debetScoreField.get(atm);
            Class scoreClass = debetScore.getClass().getSuperclass();

            Field moneyField = scoreClass.getDeclaredField("balance");
            moneyField.setAccessible(true);
            moneyField.set(debetScore, money);

            debetScoreField.set(atm, debetScore);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void setMoneyToCurrent(Money money) {
        Class atmClass = atm.getClass();
        try {
            Field currentScoreField = atmClass.getDeclaredField("currentScore");
            currentScoreField.setAccessible(true);

            CurrentScore currentScore = (CurrentScore) currentScoreField.get(atm);
            Class scoreClass = currentScore.getClass().getSuperclass();

            Field moneyField = scoreClass.getDeclaredField("balance");
            moneyField.setAccessible(true);
            moneyField.set(currentScore, money);

            currentScoreField.set(atm, currentScore);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void cleanUp() {
        atm = null;
    }

}
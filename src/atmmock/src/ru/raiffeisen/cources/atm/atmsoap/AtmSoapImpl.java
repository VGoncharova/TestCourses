package atmmock.src.ru.raiffeisen.cources.atm.atmsoap;

import atmmock.src.ru.raiffeisen.cources.atm.ATM;
import atmmock.src.ru.raiffeisen.cources.atm.ScoreTypeEnum;
import atmmock.src.ru.raiffeisen.cources.atm.model.db.DAO.AtmDAO;
import atmmock.src.ru.raiffeisen.cources.atm.model.money.Money;

public class AtmSoapImpl implements IAtmSoap {

    private ATM atm;
    private AtmDAO atmDAO;

    public AtmSoapImpl() {
        atm = new ATM();
    }

    @Override
    public void addMoney(String name, double sum) {


        if (name.equals("credit")) {
            String currencyName =atmDAO.getCurrancyName(ScoreTypeEnum.CREDIT);
            Money money = new Money(sum, currencyName);
            atm.addMoneyToScore(money, ScoreTypeEnum.CREDIT);
        }else if (name.equals("debet")) {
            String currencyName =atmDAO.getCurrancyName(ScoreTypeEnum.DEBET);
            Money money = new Money(sum, currencyName);
            atm.addMoneyToScore(money, ScoreTypeEnum.DEBET);
        }else if (name.equals("current")){
            String currencyName =atmDAO.getCurrancyName(ScoreTypeEnum.CURRENT);
            Money money = new Money(sum, currencyName);
            atm.addMoneyToScore(money, ScoreTypeEnum.CURRENT);
        }
    }

    @Override
    public void putMoney(String name, double sum) {
        if (name.equals("credit")) {
            String currencyName =atmDAO.getCurrancyName(ScoreTypeEnum.CREDIT);
            Money money = new Money(sum, currencyName);
            atm.getMoneyFromScore(money, ScoreTypeEnum.CREDIT);
        }else if (name.equals("debet")) {
            String currencyName =atmDAO.getCurrancyName(ScoreTypeEnum.DEBET);
            Money money = new Money(sum, currencyName);
            atm.getMoneyFromScore(money, ScoreTypeEnum.DEBET);
        }else if (name.equals("current")){
            String currencyName =atmDAO.getCurrancyName(ScoreTypeEnum.CURRENT);
            Money money = new Money(sum, currencyName);
            atm.getMoneyFromScore(money, ScoreTypeEnum.CURRENT);
        }
    }

}

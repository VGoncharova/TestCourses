package atmmock.src.ru.raiffeisen.cources.atm.atmsoap;

import atmmock.src.main.java.ru.raiffeisen.cources.atm.model.db.SingleConnectionManager;
import atmmock.src.ru.raiffeisen.cources.atm.ATM;
import atmmock.src.ru.raiffeisen.cources.atm.ScoreTypeEnum;
import atmmock.src.ru.raiffeisen.cources.atm.model.db.DAO.AtmDAO;
import atmmock.src.ru.raiffeisen.cources.atm.model.money.Money;

import javax.jws.WebService;

@WebService(endpointInterface = "atmmock.src.ru.raiffeisen.cources.atm.atmsoap.IAtmSoap")
public class AtmSoapImpl implements IAtmSoap {

    private ATM atm;
    private AtmDAO atmDAO;

    public AtmSoapImpl() {
        atm = new ATM();
        atmDAO=new AtmDAO(new SingleConnectionManager());
    }

    @Override
    public void addMoney(String name, double sum) {
        System.out.println("Added "+sum+" to "+name+" account");

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
        System.out.println("Put "+sum+" to "+name+" account");
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

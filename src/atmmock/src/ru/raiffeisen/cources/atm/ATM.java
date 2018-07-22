package atmmock.src.ru.raiffeisen.cources.atm;

import com.google.gson.Gson;
import atmmock.src.ru.raiffeisen.cources.atm.model.constants.CurrencyHolder;
import atmmock.src.ru.raiffeisen.cources.atm.model.money.Money;
import atmmock.src.ru.raiffeisen.cources.atm.model.score.*;

import java.io.*;
import java.lang.annotation.Annotation;
import java.util.Scanner;

public class ATM {
    private CurrentScore currentScore;
    private DebetScore debetScore;
    private CreditScore creditScore;
    private int operLimit;
    private int currentOpers;
    private boolean operLimitToggl;

    public ATM() {
        Class thisClass = this.getClass();
        for (Annotation annotation:
                thisClass.getAnnotations()) {
            if(annotation instanceof OperationLimitATM){
                this.operLimit = ((OperationLimitATM)annotation).limit();
                this.operLimitToggl = true;
            }
        }

        this.creditScore =
                new CreditScore(
                        new Money(1000.0d,
                                  CurrencyHolder.getCurrencyByName("RUR").getName()
                                 ), null, 1);
        this.debetScore =
                new DebetScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, this.creditScore);
        this.currentScore =
                new CurrentScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, this.debetScore);
    }

    public ATM(CurrentScore currentScore, DebetScore debetScore, CreditScore creditScore) {
        this.currentScore = currentScore;
        this.debetScore = debetScore;
        this.creditScore = creditScore;

        Class thisClass = this.getClass();
        for (Annotation annotation:
                thisClass.getAnnotations()) {
            if(annotation instanceof OperationLimitATM){
                this.operLimit = ((OperationLimitATM)annotation).limit();
                this.operLimitToggl = true;
            }
        }
    }

    public void addMoneyToScore(Money money, ScoreTypeEnum choice){
        if(operLimitToggl && currentOpers >= operLimit){
            System.out.println("Oper limit ends!");
            return;
        }

        switch (choice){
            case CREDIT:
                this.creditScore.addMoney(money);
                break;
            case DEBET:
                this.debetScore.addMoney(money);
                break;
            case CURRENT:
                this.currentScore.addMoney(money);
                break;
        }
        currentOpers++;
    }

    public Money getMoneyFromScore(Money money, ScoreTypeEnum choice){
        if(operLimitToggl && currentOpers >= operLimit){
            System.out.println("Oper limit ends!");
            return null;
        }
        currentOpers++;
        switch (choice){
            case CREDIT:
                return this.creditScore.getMoney(money.getValue());
            case DEBET:
                return this.debetScore.getMoney(money.getValue());
            case CURRENT:
                return this.currentScore.getMoney(money.getValue());
        }

        return null;
    }

    public void restore(DumpType dumpType){
        switch (dumpType){
            case DB:
                System.out.println("Not implemented yet!");
                break;
            case XML:
                System.out.println("Not implemented yet!");
                break;
            case JSON:
                restoreFromJSON();
                break;
        }
    }

    public void dump(DumpType dumpType){
        switch (dumpType){
            case DB:
                System.out.println("Not implemented yet!");
                break;
            case XML:
                System.out.println("Not implemented yet!");
                break;
            case JSON:
                dumpToJSON();
                break;
        }
    }

    private void restoreFromJSON(){
        File dampFile = new File("dumpJSON.txt");
        if(dampFile.exists()){
            try (FileReader fileReader = new FileReader(dampFile)){
                Scanner fileScaner = new Scanner(fileReader);
                StringBuilder atmJSONBuilder = new StringBuilder();

                String line = null;
                while (fileScaner.hasNext()) {
                    line = fileScaner.next();
                    atmJSONBuilder.append(line);
                }

                ATM newAtm = new Gson().fromJson(atmJSONBuilder.toString(), ATM.class);
                copy(newAtm);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copy(ATM atm){
        this.currentScore = atm.currentScore;
        this.debetScore = atm.debetScore;
        this.creditScore = atm.creditScore;
        this.operLimit =  atm.operLimit;
        this.currentOpers = atm.currentOpers;
        this.operLimitToggl = atm.operLimitToggl;
    }

    private void dumpToJSON(){
        String atmJSON = new Gson().toJson(this);
        File dampFile = new File("dumpJSON.txt");
        try (FileWriter fileWriter = new FileWriter(dampFile)){
            dampFile.createNewFile();
            fileWriter.write(atmJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }

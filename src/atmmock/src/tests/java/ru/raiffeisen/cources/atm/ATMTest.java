package atmmock.src.tests.java.ru.raiffeisen.cources.atm;


import atmmock.src.main.java.ru.raiffeisen.cources.atm.ATM;
import atmmock.src.main.java.ru.raiffeisen.cources.atm.ScoreTypeEnum;
import atmmock.src.main.java.ru.raiffeisen.cources.atm.model.money.Money;
import atmmock.src.tests.java.ru.raiffeisen.cources.atm.data.AtmDataSupplier;
import org.junit.jupiter.api.*;
import tests.java.atmmock.src.ru.raiffeisen.cources.atm.data.TestPair;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ATMTest {
    private static ATM atm;
    private static final AtmDataSupplier atmDataSupplier = new AtmDataSupplier();

    private static final String DUMP_STR = "{\"currentScore\":{\"debetScore\":{\"creditScore\":{\"balance\":{\"currency\":{\"name\":\"RUR\",\"usdCource\":65.5},\"value\":1000.0},\"number\":1,\"methodConstraintMap\":{},\"methodCallMap\":{},\"methodConstraintToggl\":false},\"balance\":{\"currency\":{\"name\":\"RUR\",\"usdCource\":65.5},\"value\":1000.0},\"number\":1,\"methodConstraintMap\":{},\"methodCallMap\":{},\"methodConstraintToggl\":false},\"balance\":{\"currency\":{\"name\":\"RUR\",\"usdCource\":65.5},\"value\":1000.0},\"number\":1,\"methodConstraintMap\":{},\"methodCallMap\":{},\"methodConstraintToggl\":false},\"debetScore\":{\"creditScore\":{\"balance\":{\"currency\":{\"name\":\"RUR\",\"usdCource\":65.5},\"value\":1000.0},\"number\":1,\"methodConstraintMap\":{},\"methodCallMap\":{},\"methodConstraintToggl\":false},\"balance\":{\"currency\":{\"name\":\"RUR\",\"usdCource\":65.5},\"value\":1000.0},\"number\":1,\"methodConstraintMap\":{},\"methodCallMap\":{},\"methodConstraintToggl\":false},\"creditScore\":{\"balance\":{\"currency\":{\"name\":\"RUR\",\"usdCource\":65.5},\"value\":1000.0},\"number\":1,\"methodConstraintMap\":{},\"methodCallMap\":{},\"methodConstraintToggl\":false},\"operLimit\":0,\"currentOpers\":0,\"operLimitToggl\":false}";

    @BeforeAll
    static void init(){
        atm = atmDataSupplier.getStartDataATM();
    }

    @BeforeEach
    void fillData(){
        atmDataSupplier.fillATM(atm);
    }

    @Test
    void addMoneyToScore() {
        Map<Integer, Money> testData = atmDataSupplier.getTestData();
        Map<Integer, Money> expectedData = atmDataSupplier.getExpectedData(atm);
        for (Integer key:
                testData.keySet()) {
            Money tempMoney = testData.get(key);
            atm.addMoneyToScore(tempMoney, ScoreTypeEnum.CREDIT);

            Money expectedMoney = expectedData.get(key);
            Money newMoney = atmDataSupplier.getMoneyFromCredit(atm);

            assertEquals(expectedMoney.getValue() , newMoney.getValue());
        }
    }

    @Test
    void addMoneyToScoreSecond() {
        for (TestPair<Money> pair:
             atmDataSupplier.getTestListData(atm)) {
            assertEquals(pair.getExpectedValue(), pair.getTestValue());
        }
    }

    @Test
    void getATMFromJSONString(){
        StringBuilder stringBuilder = mock(StringBuilder.class);
        when(stringBuilder.toString()).thenReturn(DUMP_STR);

        ATM newAtm = atm.getATMFromJSONString(stringBuilder);

        assertEquals(atm, newAtm);
    }

//    @Test
//    void getAllScoresBalanceFromDB(){
//        AtmDAO atmDAO = mock(AtmDAO.class);
//        when(atmDAO.getAtm()).thenReturn(atmDataSupplier.getStartDataATM());
//        atm.setAtmDAO(atmDAO);
//
//        double actualSum = atm.getAllScoresBalanceFromDB();
//
//        assertEquals(0, actualSum);
//    }


    @AfterEach
    void cleanData(){
        atmDataSupplier.fillATM(atm);
    }

    @AfterAll
    static void cleanUp(){
        atm = null;
    }

}
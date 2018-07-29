package cources;

import cources.checkers.MenuMealChecker;
import cources.checkers.MenuTestPairChecker;
import cources.data.DriverPool;
import cources.data.MenuCheckerDataSupplier;
import cources.data.MenuChoiseTestPair;
import cources.pages.DeliveryClubMainPageObject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeliveryClubTest {

    @Test
    public void pizzaTest() {
        WebDriver localDriver = DriverPool.instance.pollDriver();

        localDriver.get("https://www.delivery-club.ru/");
        DeliveryClubMainPageObject deliveryClubMainPageObject =
                new DeliveryClubMainPageObject();
        deliveryClubMainPageObject.init(localDriver);

        deliveryClubMainPageObject.gotoPizzaMenu();
        deliveryClubMainPageObject.searchByAddr("Москва, проспект Андропова, 18к1");
        deliveryClubMainPageObject.clickSubmitBtn();

        MenuMealChecker menuMealChecker =
                new MenuMealChecker(deliveryClubMainPageObject);
        assertTrue(menuMealChecker.getWrongList().toString(), menuMealChecker.check());

        assertEquals("Поиск блюд и ресторанов",
                                    deliveryClubMainPageObject
                                            .getSearchMealField()
                                            .getPlaceholderText());

        DriverPool.instance.releaseDriver(localDriver);
    }

    @Test
    public void menuTest(){
        WebDriver localDriver = DriverPool.instance.pollDriver();

        localDriver.get("https://www.delivery-club.ru/");
        DeliveryClubMainPageObject deliveryClubMainPageObject =
                new DeliveryClubMainPageObject();
        deliveryClubMainPageObject.init(localDriver);

        for (MenuChoiseTestPair pair:
                MenuCheckerDataSupplier.getTestData()) {
            deliveryClubMainPageObject.gotoMenu(pair.getClickedMenuName());
            deliveryClubMainPageObject.searchByAddr("Москва, проспект Андропова, 18к1");

            MenuTestPairChecker checker = new MenuTestPairChecker(deliveryClubMainPageObject, pair);
            assertTrue(checker.getWrongList().toString(), checker.check());
        }

        DriverPool.instance.releaseDriver(localDriver);
    }

}
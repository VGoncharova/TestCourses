package cources;

import cources.data.DriverPool;
import cources.pages.DeliveryClubMainPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class DeliveryByCorrectAddressSteps {

    private DeliveryClubMainPageObject page;

    @Given("go to {string}")
    public void preCondition(String string) {
        page = new DeliveryClubMainPageObject();
        WebDriver driver = DriverPool.instance.pollDriver();
        driver.get(string);
        page.init(driver);
    }

    @When("Enter delivery address {string}")
    public void setAddress(String address) {
        page.fillAddrField(address);
    }

    @And("Click Enter Button")
    public void executeSearch() {
        page.clickSubmitBtn();
    }

    //    @Then("We see all restaurants available for order")
    @Then("this rest is empty {string}")
    public void checkResult(String isEmpty) {
        int restResult = page.getCountRestaurants();
        assertTrue(isEmpty.equals("false") == restResult > 0);
    }
}

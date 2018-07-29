package cources;

import cources.data.DriverPool;
import cources.pages.DeliveryClubMainPageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ChangeBannerFeatureSteps {
    private DeliveryClubMainPageObject page;

    @Given("Go to {string}")
    public void preCondition(String string) {
        page = new DeliveryClubMainPageObject();
        WebDriver driver = DriverPool.instance.pollDriver();
        driver.get(string);
        page.init(driver);
    }

    @When("click to {int} banner round")
    public void actionOne(Integer bannerNum) {
        page.clickBannerBtnByNum(bannerNum);
    }

    @When("click to {string} banner button")
    public void actionTwo(String direction) {
        page.clickArrowBannerButton(direction);
    }

    @Then("we see {string} image url")
    public void checkResult(String expectedImageUrl) {
        assertEquals(expectedImageUrl, page.getActiveBannerImageUrl());
    }
}

package cources;

import cources.data.DriverPool;
import cources.data.FilterValue;
import cources.pages.DeliveryClubMainPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CheckBoxFoodMenuSteps {
    private DeliveryClubMainPageObject page;

    @Given("^checked on food/entity")
    public void checkOnFoodEntity(List<String> checked){
        page = new DeliveryClubMainPageObject();
        page.init(DriverPool.instance.pollDriver());

        page.gotoFoodEntity();
        for (String checkName:
             checked) {
            page.checkSomeCheckBoxByName(checkName);
        }
    }

    @Given("^checked and unchecked on food/entity")
    public void checkUncheckOnFoodEntity(Map<String, Boolean> checkedMap){
        page = new DeliveryClubMainPageObject();
        page.init(DriverPool.instance.pollDriver());

        page.gotoFoodEntity();
        for (String checkName:
             checkedMap.keySet()) {
            if(checkedMap.get(checkName)){
                page.checkSomeCheckBoxByName(checkName);
            } else {
                page.uncheckSomeCheckBoxByName(checkName);
            }
        }
    }

    @Given("^filter value")
    public void filterVals(List<FilterValue> filterValues){
        System.out.println(filterValues.toString());
    }

    @When("^i enter address (.*)$")
    public void enterAddress(String address){

    }

    @And("^click search$")
    public void clickSearch(){

    }

    @Then("^i find (\\d+) restaurant$")
    public void checkRestaurants(int restCount){

    }
}

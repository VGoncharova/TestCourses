package cources;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

public class TestCucumberSteps {

    private int counterMonkey;
    private int seeCounter;
    private String phrase;

    @Given("^some list of values")
    public void givenList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Given("^some map of values")
    public void givenMap(Map<String, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    @Given(value = "^i give you (\\d+) naked monkeys$", timeout = 5)
    public void preCondition(int monkeyCount){
        counterMonkey = monkeyCount;
        System.out.println("User: Out precondition is " + monkeyCount);
    }

    @When("^you see them (\\d+) times$")
    public void actionOne(int seeThem){
        seeCounter = seeThem;
        System.out.println("User: our action is see " + seeThem);
    }

    @And("^scream (.*)$")
    public void actionTwo(String phrase){
        this.phrase = phrase;
        System.out.println("User: " + phrase);
    }

    @Then("^monkeys run out (.*)$")
    public void checking(String result){
        System.out.println("User: counterMonkey=" + counterMonkey);
        System.out.println("User: seeCounter=" + seeCounter);
        System.out.println("User: phrase=" + phrase);
        System.out.println("User: result=" + result);
    }
}

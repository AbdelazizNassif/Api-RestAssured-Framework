package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DummyMyStepdefs {
    @Given("user init the request sucessfully")
    public void userInitTheRequestSucessfully() {
        System.out.println("Dummy Given");
    }

    @When("user created place body successfully")
    public void userCreatedPlaceBodySuccessfully() {
        System.out.println("Dummy when");
    }

    @Then("{string} status will be {string}")
    public void statusWillBe(String arg0, String arg1) {
        System.out.println("Dummy then");

    }
}

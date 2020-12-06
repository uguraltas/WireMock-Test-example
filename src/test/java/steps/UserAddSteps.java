package steps;

import Mocks.Mock;
import helpers.ResponseHelper;
import utils.ResponseUtil;
import utils.RequestUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class UserAddSteps {
    @Given("^I start WireMock for (\\w+(?: \\w+)*) response$")
    public void startWireMock(String response) {
        Mock.response(response);
    }

    @When("^I adding new user with this data:$")
    public void addUser(DataTable dataTable) {
        RequestUtil.getRequest(dataTable);
    }

    @Then("^the status is 200 in the response$")
    public void statusCodeControl() {
        ResponseHelper.checkStatusCode();
    }
    @And("^the elements equal to the followings in the response$")
    public void statusControl(DataTable dataTable) {
        ResponseHelper.isContainsResponse(dataTable);
    }
}

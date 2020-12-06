package steps;

import Mocks.Mock;
import helpers.ResponseHelper;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utils.ResponseUtil;
import utils.RequestUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class UserAddSteps {

    public Response response =null;


    @Given("^I start WireMock for (\\w+(?: \\w+)*) response$")
    public void startWireMock(String response) {
        Mock.response(response);
    }

    @When("^I adding new user with this data:$")
    public void addUser(DataTable dataTable) {
        JSONObject requestJson = RequestUtil.getRequest(dataTable);
        response = ResponseUtil.getResponse(requestJson);
    }

    @Then("^the status is 200 in the response$")
    public void statusCodeControl() {
        ResponseHelper.checkStatusCode(response);
    }

    @And("^the elements equal to the followings in the response$")
    public void statusControl(DataTable dataTable) {
        ResponseHelper.isContainsResponse(dataTable,response);
    }
}

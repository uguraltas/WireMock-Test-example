package helpers;

import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.containsString;


public class ResponseHelper {

    public static void checkStatusCode(Response response) {

        int statusCode = response.statusCode();

        if (statusCode == 200) {
            System.out.println("status code is 200");
        } else {
            System.out.println("status code is not 200");
        }
    }

    public static void isContainsResponse(DataTable dataTable, Response response) {
        for (DataTableRow row : dataTable.getGherkinRows()) {

            String key = row.getCells().get(0);
            String value = row.getCells().get(1);

            response.then().assertThat().body(key,containsString(value));
        }
    }
}

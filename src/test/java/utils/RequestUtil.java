package utils;


import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import org.json.simple.JSONObject;

public class RequestUtil {

    public static JSONObject requestJson;

    public static JSONObject getRequest(DataTable dataTable) {
        for (DataTableRow row : dataTable.getGherkinRows()) {

            String key = row.getCells().get(0);
            String value = row.getCells().get(1);

            JSONObject requestJson=new JSONObject();
            requestJson.put(key,value);
        }
        return requestJson;
    }
}


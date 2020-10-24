package glueCode;

import com.jayway.restassured.response.Response;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utilities.Utils;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;

public class StepDefAPI extends Utils {

    private Response response;

    @Given("^To initiate Rest service to get charities list$")
    public void to_Initiate_Rest_Service_To_Get_Charities_List() throws Throwable {
        setBaseURI();
        cratePath("/v1/Charities.json");
        response = getResponse();
        //System.out.println("************The Response value as --" + response.prettyPrint());
    }

    @Then("^Response status code should be \"([^\"]*)\"$")
    public void response_status_code_should_be(Integer arg1) throws Throwable {
        // To verify the response status code
        assertEquals("Status Check Failed!", (long)arg1, response.getStatusCode());

    }

    @Then("^the response should include below value$")
    public void the_response_should_include_below_value(DataTable value) {
        List <List<String>> data = value.raw();
        response.then().body("Description", hasItem(data.get(0).get(0)));
    }


    @Given("^To initiate Rest service to get used car list$")
    public void to_initiate_Rest_service_to_get_used_car_list() {
        setBaseURI();
        cratePath("/v1/Search/Motors/Used.json");
        response = getAuthResponse();
        //System.out.println("************The Response value as --" + response.prettyPrint());
    }


    @Then("^the response should include below attributes with value$")
    public void the_response_should_include_below_attributes_with_value(DataTable value) {
        List <List<String>> data = value.raw();
        for (int i=1;i <= data.size(); i++) {
            response.then().body(data.get(i).get(0), hasItem(data.get(i).get(1)));
        }
    }

}


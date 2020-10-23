package glueCode;

import com.jayway.restassured.response.Response;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utilities.Utils;

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

    @Then("^response should includes \"([^\"]*)\"$")
    public void response_should_includes(String arg1) {
        response.then().body("Description", hasItem(arg1));
    }

    @Given("^To initiate Rest service to get used car list$")
    public void to_initiate_Rest_service_to_get_used_car_list() {
        setBaseURI();
        cratePath("/v1/Search/Motors/Used.json");
        response = getAuthResponse();
        //System.out.println("************The Response value as --" + response.prettyPrint());
    }

    @Then("^The \"([^\"]*)\" is returned in the response with value \"([^\"]*)\"$")
    public void the_is_returned_in_the_response_with_value(String arg1, String arg2)  {
    response.then().body(arg1, hasItem(arg2));

    }

}


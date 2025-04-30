package uk.gov.hmcts.cp.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClient;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTestSteps extends BaseSteps {

    @Given("System is running")
    public void systemIsRunning() {
        cleatLocalData();
    }

    @When("We make a request to Swagger Hub")
    public void weMakeARequestToWSwaggerHub() {
        RestClient client = RestClient.create();
        setBody(client.get()
            .uri(BASE_API_URL + API_COURTHOUSES + "/1234")
            .retrieve()
            .body(HashMap.class));
    }

    @Then("We receive a response from Swagger Hub")
    public void weReceiveAResponseFromSwaggerHub() {
        HashMap<String, Object> body = getBody();
        assertThat(body).containsKey("courtHouse");
    }
}

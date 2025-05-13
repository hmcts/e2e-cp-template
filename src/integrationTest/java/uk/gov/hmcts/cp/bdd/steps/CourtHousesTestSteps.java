package uk.gov.hmcts.cp.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClient;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CourtHousesTestSteps extends BaseSteps {

    @Given("courtHouses System is running")
    public void systemIsRunning() {
        cleatLocalData();
    }

    @When("We make a request to courtHouses Swagger Hub by id {string}")
    public void weMakeARequestToWSwaggerHub() {
        RestClient client = RestClient.create();
        setBody(client.get()
            .uri(COURTHOUSES_BASE_API_URL + COURTHOUSES_API + "/1234")
            .retrieve()
            .body(HashMap.class));
    }

    @Then("We receive a response from Swagger Hub for courtHouses")
    public void weReceiveAResponseFromSwaggerHub() {
        HashMap<String, Object> body = getBody();
        assertThat(body).containsKey("courtHouse");
    }
}

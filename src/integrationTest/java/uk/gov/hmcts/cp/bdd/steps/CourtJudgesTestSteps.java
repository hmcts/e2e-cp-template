package uk.gov.hmcts.cp.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClient;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CourtJudgesTestSteps extends BaseSteps {

    @Given("courtJudges System is running")
    public void systemIsRunning() {
        cleatLocalData();
    }

    @When("We make a request to courtJudges Swagger Hub by id {string}")
    public void weMakeARequestToWSwaggerHub(String id) {
        RestClient client = RestClient.create();
        setBody(client.get()
                    .uri(COURTJUDGES_BASE_API_URL + COURTJUDGES_API + "/id")
                    .retrieve()
                    .body(HashMap.class));
    }

    @Then("We receive a response from Swagger Hub for courtJudges")
    public void weReceiveAResponseFromSwaggerHub() {
        HashMap<String, Object> body = getBody();
        assertThat(body).containsKey("judiciary");
    }


}

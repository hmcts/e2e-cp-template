package uk.gov.hmcts.cp.bdd.steps;

import java.util.HashMap;

public class BaseSteps {

    private static final String BASE_API_VERSION = "0.0.2";
    public static final String BASE_API_URL = "https://virtserver.swaggerhub.com/HMCTS-DTS/api-cp-refdata-courthearing-courthouses/" + BASE_API_VERSION;
    public static final String API_COURTHOUSES = "/courthouses";

    private static final String BODY = "body";

    private final HashMap<String, Object> localData = new HashMap<>();

    public void cleatLocalData() {
        this.localData.clear();
    }

    public <T> void setBody(T body) {
        this.localData.put(BODY, body);
    }

    @SuppressWarnings("unchecked")
    public <T> T getBody() {
        return (T) this.localData.get(BODY);
    }
}

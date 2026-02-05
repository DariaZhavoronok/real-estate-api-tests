import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class RequestHandler {
    private static final String AGENT_HEADER = ConfigReader.getUserAgentHeader();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> ValidatableResponse postEntity(final T entity,
                                                     final String url) {
        String bodyAsJsonString;
        try {
            bodyAsJsonString = mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize request body for URL: " + url, e);
        }

        return RequestHandler.sendPostRequest(url, bodyAsJsonString);
    }

    public static ValidatableResponse getEntity(final String url) {
        return RequestHandler.sendGetRequest(url);
    }

    public static ValidatableResponse sendPostRequest(final String url,
                                                      final Object body) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", AGENT_HEADER)
                .body(body)
                .post(url)
                .then();
    }

    public static ValidatableResponse sendGetRequest(final String url) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", AGENT_HEADER)
                .get(url)
                .then();
    }
}

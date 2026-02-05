import dto.request.agent.AgentAddressDto;
import dto.request.agent.AgentSearchDto;
import dto.response.agentsResponse.AgentsDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class SearchForAgentTests {

    @Test
    public void userShouldBeAbleToSearchAnAgentByAddressTest() {
        log.info("Running scenario : User should be able to search the agent based on the address");
        // Here should be POST call to create search result that we control as test setup
        final AgentSearchDto searchRequest = getAgentsSearchRequest();

        log.info("Sending POST request for Search Agents endpoint");
        var response = EntitiesRequestManagement.sendPostRequestForAgentsSearch(searchRequest);

        log.info("Validating status code and fields values");
        assertThat(response.extract().statusCode(), is(HttpStatus.SC_OK));
        final AgentsDto actualSearchResponse = response.extract().as(AgentsDto.class);
        verifySearchResponse(actualSearchResponse);
    }

    // For now, I keep assertions and builders within this class for better visibility.
    // If the class becomes too large or these methods are shared, it will be time to move them out.
    private static void verifySearchResponse(final AgentsDto response) {
        // Ideally, I would compare AgentsResponseDto objects instead of asserting fields. But for that I need to
        // control entities
        assertThat("Agents data should be present",
                response.getData(), is(not(nullValue())));
    }

    public static AgentSearchDto getAgentsSearchRequest(){
        return AgentSearchDto.builder()
                .address(AgentAddressDto.builder()
                        .postalCode("1056 JT")
                        .houseNumber(58)
                        .addition("1")
                        .build())
                .service("verkoop")
                .pageSize(10)
                .sortBy("relevance")
                .page(0)
                .build();
    }
}

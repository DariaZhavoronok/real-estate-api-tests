import dto.request.ContactAgentRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class ContactAgentTest {

    @Test
    public static void userShouldBeAbleToContactTheAgentTest() {
        log.info("Running scenario : User should be able to contact the agent successfully");
        final String officeId = "1";
        final ContactAgentRequestDto contactAgentRequest = getContactAgentRequest();

        log.info("Sending POST request for Contact Agent endpoint");
        var response = EntitiesRequestManagement.sendPostRequestForContactAgent(contactAgentRequest, officeId);

        log.info("Validating status code");
        assertThat(response.extract().statusCode(), is(HttpStatus.SC_NO_CONTENT));
    }

    private static ContactAgentRequestDto getContactAgentRequest() {
        return ContactAgentRequestDto.builder()
                .firstName("user")
                .lastName("tester")
                .emailAddress("someMail@gmail.com")
                .phoneNumber("+3167777777")
                .message("Take my money!")
                .days(Collections.emptyList())
                .dayParts(Collections.emptyList())
                .anonymousUserId("f2b40c2d-cfaa-4c5e-a76c-ac074fdf68a8")
                .userId(null)
                .loggedIn(false)
                .acceptedCookies(true)
                .build();
    }
}

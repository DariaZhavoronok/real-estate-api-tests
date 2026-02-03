package dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactAgentRequestDto {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String message;
    private List<String> days;
    private List<String> dayParts;
    private String anonymousUserId;
    private String userId;
    private boolean loggedIn;
    private boolean acceptedCookies;
}


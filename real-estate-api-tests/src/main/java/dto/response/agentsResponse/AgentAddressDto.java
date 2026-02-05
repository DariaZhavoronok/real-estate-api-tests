package dto.response.agentsResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentAddressDto {

    @JsonProperty("street")
    private String street;

    @JsonProperty("number")
    private String number;

    @JsonProperty("addition")
    private String addition;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("city")
    private String city;
}

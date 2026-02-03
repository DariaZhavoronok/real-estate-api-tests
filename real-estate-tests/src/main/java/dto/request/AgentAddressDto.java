package dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgentAddressDto {
    private String postalCode;
    private Integer houseNumber;
    private String addition;
}

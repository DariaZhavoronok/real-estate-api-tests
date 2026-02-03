package dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import dto.response.AddressDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgentSearchRequestDto {
    private AgentAddressDto address;
    private String service;
    private Integer pageSize;
    private String sortBy;
    private Integer page;
}
package dto.request.agent;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgentSearchDto {
    private AgentAddressDto address;
    private String service;
    private Integer pageSize;
    private String sortBy;
    private Integer page;
}
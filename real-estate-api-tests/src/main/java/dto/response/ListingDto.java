package dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingDto {
    private String price;
    private boolean isSinglePrice;
    private String agentName;
    private String agentUrl;
    private String listingUrl;
    private long globalId;
    private long brokerGlobalId;
    private List<String> labels;
    private boolean isProject;
}
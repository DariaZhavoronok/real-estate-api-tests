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
public class AgentListingDto {

    @JsonProperty("listingId")
    private String listingId;

    @JsonProperty("location")
    private LocationDto location;

    @JsonProperty("image")
    private String image;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("formattedPrice")
    private String formattedPrice;

    @JsonProperty("priceType")
    private String priceType;

    @JsonProperty("priceCondition")
    private String priceCondition;

    @JsonProperty("publicationDate")
    private String publicationDate;

    @JsonProperty("transactionDate")
    private String transactionDate;

    @JsonProperty("detailUrl")
    private String detailUrl;
}


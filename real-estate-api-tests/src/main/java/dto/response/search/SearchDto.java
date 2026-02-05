package dto.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.response.listing.ListingDto;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchDto {
    private String friendlyUrl;
    private List<ListingDto> listings;
}

package dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private List<String> aggregationType;
    private List<String> constructionType;
    private List<String> offeringType;
    private PriceDto price;
    private String geoInformation;
    private List<String> zoning;
    private String cultureInfo;
    private Integer page;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PriceDto {
        private String priceRangeType;
        private Integer lowerBound;
        private Integer upperBound;
    }
}
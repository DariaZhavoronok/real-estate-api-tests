import dto.request.SearchRequestDto;
import dto.response.SearchResponseDto;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class PropertySearchTests {

    @DataProvider
    public static Object[][] offeringType() {
        return new Object[][]{
                {
                        SearchTestData
                                .builder()
                                .description("User should be able to search properties for sale")
                                .aggregationType("listing")
                                .offeringType("buy")
                                .constructionType(null)
                                .build()
                },
                {
                        SearchTestData
                                .builder()
                                .description("User should be able to search properties for rent")
                                .aggregationType("listing")
                                .offeringType("rent")
                                .constructionType(null)
                                .build()                },
                {
                        SearchTestData
                                .builder()
                                .description("User should be able to search properties for new buildings")
                                .aggregationType("project")
                                .offeringType("buy")
                                .constructionType("new")
                                .build()
                }
        };
    }

    @Test(dataProvider = "offeringType")
    public void userShouldBeAbleToSearchPropertyTest(final SearchTestData testData) {
        log.info("Running scenario : {}", testData.description);
        // Here should be POST call to create search result that we control
        final SearchRequestDto searchRequest = getSearchRequestForOfferingType(testData);

        log.info("Sending POST request for Search endpoint");
        var response = EntitiesRequestManagement.sendPostRequestForSearch(searchRequest);

        log.info("Validating status code and fields values");
        assertThat(response.extract().statusCode(), is(HttpStatus.SC_OK));
        final SearchResponseDto actualSearchResponse = response.extract().as(SearchResponseDto.class);
        verifySearchResponse(actualSearchResponse);
    }

    //Bugfix
    @Test
    public void searchRequestWithEmptyBodyShouldReturn400Test() {
        log.info("Running scenario: when Search request without body - 400 should be returned");

        log.info("Sending POST request for Search endpoint");
        var response = RequestHandler.sendPostRequest(EntityApiUrls.SEARCH_PATH_URL, "{ }");

        log.info("Validating status code and fields values");
        assertThat(response.extract().statusCode(), is(HttpStatus.SC_BAD_REQUEST));
    }

    // For now, I keep assertions and builders within this class for better visibility.
    // If the class becomes too large or these methods are shared, it will be time to move them out.
    private static void verifySearchResponse(final SearchResponseDto response) {
        // Ideally, I would compare SearchResponseDto objects instead of asserting fields. But for that I need to
        // control entities
        assertThat("friendlyUrl should be present",
                response.getFriendlyUrl(), is(not(nullValue())));

        assertThat("listings should not be empty",
                response.getListings(), is(not(empty())));
    }

    // Builds the search request
    private static SearchRequestDto getSearchRequestForOfferingType(final SearchTestData testData) {
        return SearchRequestDto.builder()
                .aggregationType(RequestFieldUtils.nullableList(testData.aggregationType))
                .offeringType(RequestFieldUtils.nullableList(testData.offeringType))
                .constructionType(RequestFieldUtils.nullableList(testData.constructionType))
                .price(
                        SearchRequestDto.PriceDto.builder()
                                .priceRangeType("SalePrice")
                                .lowerBound(100)
                                .upperBound(1000000)
                                .build()
                )
                .geoInformation("1056jt")
                .zoning(List.of("residential"))
                .cultureInfo("en")
                .page(1)
                .build();
    }

    @Builder
    public static class SearchTestData{
        private String description;
        private String offeringType;
        private String aggregationType;
        private String constructionType;
    }
}

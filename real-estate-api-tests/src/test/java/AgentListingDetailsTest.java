import dto.response.agentsResponse.AgentAddressDto;
import dto.response.agentsResponse.AgentListingDto;
import dto.response.agentsResponse.AgentOfferingDto;
import dto.response.agentsResponse.LocationDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class AgentListingDetailsTest {
    private static final String LISTING_ID = "7879517";
    private static final String AGENT_ID = "71032";

    @Test
    public void userShouldBeAbleToRetrievePropertyDetailsPage() {
        //Here I would set up an entity that we would assert further in the test
        log.info("Running scenario : User should be able to retrieve property details page");
        var response = EntitiesRequestManagement
                .sendGetRequestForAgentListingPortfolioById(AGENT_ID);

        log.info("Validating response status code");
        assertThat(response.extract().statusCode(), is(HttpStatus.SC_OK));

        final AgentListingDto expectedListingDetails = getExpectedListingForId(LISTING_ID);
        final AgentOfferingDto actualResponse = response.extract().as(AgentOfferingDto.class);

        AgentListingDto actualListing = findListingInOfferings(actualResponse, expectedListingDetails)
                .orElseThrow(() -> new AssertionError(
                        "Expected listing not found in agent offerings for detailUrl: "
                                + expectedListingDetails.getDetailUrl())
                );
        assertThat(actualListing, is(expectedListingDetails));
    }

    private static Optional<AgentListingDto> findListingInOfferings(AgentOfferingDto offering,
                                                                    AgentListingDto expected) {
        return offering.getOffering().stream()
                .flatMap(o -> o.getListings().stream())
                .filter(listing -> listing.getDetailUrl().equals(expected.getDetailUrl()))
                .findFirst();
    }

    private static AgentListingDto getExpectedListingForId(final String id) {
            return AgentListingDto.builder()
                    .listingId(id)
                    .location(
                            LocationDto.builder()
                                    .latitude(51.447624)
                                    .longitude(5.45903)
                                    .address(
                                            AgentAddressDto.builder()
                                                    .street("Philitelaan")
                                                    .number("59")
                                                    .addition("263")
                                                    .postcode("5617 AK")
                                                    .city("Eindhoven")
                                                    .build()
                                    )
                                    .build()
                    )
                    .image("https://cloud.funda.nl/valentina_media/224/083/940.jpg?options=width=360,fit=scale-down")
                    .price(1295)
                    .formattedPrice("1.295")
                    .priceType("Regular")
                    .priceCondition("PerMonth")
                    .publicationDate("2026-02-03T17:00:02.36Z")
                    .transactionDate(null)
                    .detailUrl("/detail/43224970/")
                    .build();
        }

}

import dto.response.listing.AddressDto;
import dto.response.listing.FastViewDto;
import dto.response.listing.IdentifiersDto;
import dto.response.listing.ListingDto;
import dto.response.listing.PriceDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class ListingDetailsTest {
        private static final String LISTING_ID = "7879517";

    @Test
    public void userShouldBeAbleToRetrievePropertyDetailsPage() {
        //Here I would set up an entity that we would assert further in the test
        log.info("Running scenario : User should be able to retrieve property details page");
        var response = EntitiesRequestManagement
                .sendGetRequestForListingPropertyById(LISTING_ID);

        log.info("Validating response status code");
        assertThat(response.extract().statusCode(), is(HttpStatus.SC_OK));

        final ListingDto actualListingDetails = response.extract().as(ListingDto.class);
        final ListingDto expectedListingDetails = getExpectedListingForId(LISTING_ID);

        log.info("Validating listing details response matches expected data");
        assertThat(actualListingDetails, is(expectedListingDetails));
    }

    private static ListingDto getExpectedListingForId(final String id) {
        return ListingDto.builder()
                .identifiers(IdentifiersDto.builder()
                        .globalId(id)
                        .tinyId("43224970")
                        .build())
                .price(PriceDto.builder()
                        .rentalPrice("€ 1.295 /mnd")
                        .build())
                .address(AddressDto.builder()
                        .title("Philitelaan 59-263")
                        .subTitle("5617 AK Eindhoven")
                        .city("Eindhoven")
                        .postCode("5617AK")
                        .build())
                .fastView(FastViewDto.builder()
                        .livingArea("61 m²")
                        .numberOfBedrooms("1")
                        .energyLabel("A")
                        .build())
                .build();
    }
}

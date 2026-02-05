public class EntityApiUrls {
    public static final String HOST = ConfigReader.getProtocol();
    public static final String V_2 = "v2.0";
    public static final String SEARCH_PATH_URL = HOST + "search-topposition.funda.io/" + V_2 + "/search";
    public static final String CONTACT_AGENT_URL = HOST + "contacts-bff.funda.io/api/v2/contact/listings/7848363/contact-request?officeId=%s&website=Funda";
    public static final String SEARCH_FOR_AGENT_PATH_URL = HOST + "www.funda.nl/makelaar-zoeken/api/agents/";
    public static final String LISTING_PROPERTY_DETAILS_URL = HOST + "listing-detail-summary.funda.io/api/v1/listing/nl/%s";
    public static final String LISTING_AGENT_DETAILS_URL = HOST + "brokerpresentation-office-pages-bff.funda.io/api/v3.0/office-page/wonen/%s/nl/listings";

    public static String getContactAgentWithOfficeIdUrl(final String officeId){
        return String.format(CONTACT_AGENT_URL, officeId);
    }

    public static String getListingPropertyDetailsUrlWithId(final String id){
        return String.format(LISTING_PROPERTY_DETAILS_URL, id);
    }

    public static String getListingAgentDetailsUrlWithId(final String id){
        return String.format(LISTING_AGENT_DETAILS_URL, id);
    }
}

import dto.request.agent.AgentSearchDto;
import dto.request.agent.ContactAgentDto;
import dto.request.search.SearchDto;
import io.restassured.response.ValidatableResponse;

public class EntitiesRequestManagement {

    public static ValidatableResponse sendPostRequestForSearch(final SearchDto searchRequest){
        return RequestHandler.postEntity(searchRequest, EntityApiUrls.SEARCH_PATH_URL);
    }

    public static ValidatableResponse sendPostRequestForAgentsSearch(final AgentSearchDto searchRequest){
        return RequestHandler.postEntity(searchRequest, EntityApiUrls.SEARCH_FOR_AGENT_PATH_URL);
    }

    public static ValidatableResponse sendPostRequestForContactAgent(final ContactAgentDto contactRequest,
                                                                     final String officeId){
        return RequestHandler.postEntity(contactRequest, EntityApiUrls.getContactAgentWithOfficeIdUrl(officeId));
    }

    public static ValidatableResponse sendGetRequestForListingPropertyById(final String propertyId){
        return RequestHandler.getEntity(EntityApiUrls.getListingPropertyDetailsUrlWithId(propertyId));
    }

    public static ValidatableResponse sendGetRequestForAgentListingPortfolioById(final String agentId){
        return RequestHandler.getEntity(EntityApiUrls.getListingAgentDetailsUrlWithId(agentId));
    }
}

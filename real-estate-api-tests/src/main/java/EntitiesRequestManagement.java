import dto.request.AgentSearchRequestDto;
import dto.request.ContactAgentRequestDto;
import dto.request.SearchRequestDto;
import io.restassured.response.ValidatableResponse;

public class EntitiesRequestManagement {

    public static ValidatableResponse sendPostRequestForSearch(final SearchRequestDto searchRequest){
        return RequestHandler.postEntity(searchRequest, EntityApiUrls.SEARCH_PATH_URL);
    }

    public static ValidatableResponse sendPostRequestForAgentsSearch(final AgentSearchRequestDto searchRequest){
        return RequestHandler.postEntity(searchRequest, EntityApiUrls.SEARCH_FOR_AGENT_PATH_URL);
    }

    public static ValidatableResponse sendPostRequestForContactAgent(final ContactAgentRequestDto contactRequest,
                                                                     final String officeId){
        return RequestHandler.postEntity(contactRequest, EntityApiUrls.getContactAgentWithOfficeIdUrl(officeId));
    }
}

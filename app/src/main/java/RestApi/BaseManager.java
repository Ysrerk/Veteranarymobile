package RestApi;

public class BaseManager {
    public RestApi getRestApiClient(){
        RestApiClient restApiClient=new RestApiClient(BaseUrl.baseurl);
        return restApiClient.getRestApi();

    }
}

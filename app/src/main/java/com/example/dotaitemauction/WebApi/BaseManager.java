package com.example.dotaitemauction.WebApi;

public class BaseManager {
    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient ( BaseUrl.model_Url );

        return restApiClient.getRestApi ();
    }

}

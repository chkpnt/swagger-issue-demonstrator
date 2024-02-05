package org.example.applicationapi.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.example.applicationapi.ApiClient;
import org.example.applicationapi.ApiException;
import org.example.applicationapi.Configuration;
import org.example.applicationapi.Pair;
import org.example.applicationapi.model.Application;

public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Submit an application
     * Submission of a new application.
     * @param body the application (required)
     * @return Application
     * @throws ApiException if fails to make API call
     */
    public Application createApplication(Application body) throws ApiException {
        Object localVarPostBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException(400, "Missing the required parameter 'body' when calling createApplication");
        }
        // create path and map variables
        String localVarPath = "/application";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {"application/json"};
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = {"application/json"};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {};

        GenericType<Application> localVarReturnType = new GenericType<Application>() {};
        return apiClient.invokeAPI(
                localVarPath,
                "POST",
                localVarQueryParams,
                localVarPostBody,
                localVarHeaderParams,
                localVarFormParams,
                localVarAccept,
                localVarContentType,
                localVarAuthNames,
                localVarReturnType);
    }
}

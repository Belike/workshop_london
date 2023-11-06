package org.camunda.consulting.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.camunda.consulting.auth.ApiKeyAuthentication;
import org.camunda.consulting.model.HappyRequest;
import org.camunda.consulting.model.HappyResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class HttpService {

    private final ObjectMapper objectMapper;

    public HttpService(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public List<HappyResponse> executeHappyRequest(HappyRequest happyRequest) throws IOException {
        final HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();

        GenericUrl genericUrl = new GenericUrl(happyRequest.getUrl().getValue());
        if(happyRequest.getAuthentication() != null){
            if (happyRequest.getAuthentication() instanceof ApiKeyAuthentication){
                genericUrl.put("api_key", ((ApiKeyAuthentication) happyRequest.getAuthentication()).getApiKey());
            }
        }
        if(happyRequest.getQueryParameters() != null) {
            happyRequest.getQueryParameters().entrySet().stream().forEach(param -> genericUrl.put(param.getKey(), param.getValue()));
        }
        HttpRequest request = requestFactory.buildGetRequest(genericUrl);
        HttpHeaders headers = request.getHeaders();
        headers.setContentType(ContentType.APPLICATION_JSON.getMimeType());
        HttpResponse httpResponse = request.execute();
        if(httpResponse.getStatusCode() == 200){
            List<HappyResponse> happyResponseList = Arrays.asList(objectMapper.readValue(httpResponse.parseAsString(),HappyResponse[].class));
            return happyResponseList;
        }else{
            throw new IOException("Exception: Status Code is {} " + httpResponse.getStatusCode());
        }
    }
}

package org.camunda.consulting.auth;

import com.google.api.client.http.HttpHeaders;
import io.camunda.connector.api.annotation.FEEL;
import io.camunda.connector.generator.annotation.TemplateProperty;
import io.camunda.connector.generator.annotation.TemplateSubType;
import lombok.Getter;
import lombok.Setter;


@TemplateSubType(id = ApiKeyAuthentication.TYPE, label = "ApiKey")
public final class ApiKeyAuthentication extends Authentication {

    public ApiKeyAuthentication(){

    }
    public ApiKeyAuthentication(String apiKey){
        this.apiKey = apiKey;
    }

    @FEEL
    @TemplateProperty(group = "authentication", label = "X-API-Key")
    @Getter
    @Setter
    private String apiKey;

    @TemplateProperty(ignore = true)
    public static final String TYPE = "ApiKey";

    @Override
    public void setHeaders(HttpHeaders headers) {

    }
}

package org.camunda.consulting.auth;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.api.client.http.HttpHeaders;
import io.camunda.connector.generator.annotation.TemplateDiscriminatorProperty;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoAuthentication.class, name = NoAuthentication.TYPE),
        @JsonSubTypes.Type(value = ApiKeyAuthentication.class, name = ApiKeyAuthentication.TYPE)
})
@TemplateDiscriminatorProperty(
        label = "Type",
        group = "authentication",
        name = "type",
        defaultValue = NoAuthentication.TYPE,
        description = "Choose the authentication type. Select 'None' if no authentication is necessary")
public abstract sealed class Authentication
        permits ApiKeyAuthentication, NoAuthentication {

    public abstract void setHeaders(HttpHeaders headers);
}

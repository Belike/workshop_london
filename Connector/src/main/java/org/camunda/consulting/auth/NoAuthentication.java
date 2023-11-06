package org.camunda.consulting.auth;

import com.google.api.client.http.HttpHeaders;
import io.camunda.connector.generator.annotation.TemplateProperty;
import io.camunda.connector.generator.annotation.TemplateSubType;

@TemplateSubType(id = NoAuthentication.TYPE, label = "None")
public final class NoAuthentication extends Authentication {

    @TemplateProperty(ignore = true)
    public static final String TYPE = "noAuth";

    @Override
    public void setHeaders(HttpHeaders headers) {

    }
}

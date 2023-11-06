package org.camunda.consulting.model;

import io.camunda.connector.api.annotation.FEEL;
import io.camunda.connector.generator.annotation.TemplateProperty;
import io.camunda.connector.generator.dsl.Property;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.camunda.consulting.auth.Authentication;

import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class HappyRequest {

    @FEEL
    @NotNull
    @TemplateProperty(group = "endpoint", id = "URL")
    @Getter
    @Setter
    private HappyUrl url;

    @Valid
    @Getter
    @Setter
    private Authentication authentication;

    @TemplateProperty(
            group = "timeout",
            defaultValue = "20",
            optional = true,
            description = "Sets the timeout in seconds to establish connection or 0 for an infinite timeout")
    @Getter
    @Setter
    private Integer connectionTimeoutInSeconds;

    @FEEL
    @TemplateProperty(
            feel = Property.FeelMode.required,
            group = "endpoint",
            optional = true,
            description = "Map of query parameters to add to the request URL")
    @Getter
    @Setter
    private Map<String, String> queryParameters;

       public boolean hasQueryParameters() {
        return queryParameters != null;
    }

    public boolean hasAuthentication() {
        return authentication != null;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        HappyRequest that = (HappyRequest) obj;
        return url.equals(that.url)
                && Objects.equals(authentication, that.authentication)
                && Objects.equals(connectionTimeoutInSeconds, that.connectionTimeoutInSeconds)
                && Objects.equals(queryParameters, that.queryParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, authentication, connectionTimeoutInSeconds, queryParameters);
    }
}

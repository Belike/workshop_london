package org.camunda.consulting;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.camunda.connector.feel.ConnectorsObjectMapperSupplier;
import io.camunda.connector.generator.annotation.ElementTemplate;
import lombok.extern.slf4j.Slf4j;
import org.camunda.consulting.model.HappyRequest;
import org.camunda.consulting.model.HappyResponse;
import org.camunda.consulting.service.HttpService;

import java.io.IOException;
import java.util.List;

@OutboundConnector(
    name = "HAPPY HTTP REST",
    inputVariables = {
            "url",
            "authentication",
            "queryParameters",
            "connectionTimeoutInSeconds"
    },
    type = "org.camunda.consulting:happy-http:1")
@ElementTemplate(
    id = "org.camunda.connectors.HappyHttp.v1",
    name = "Happy REST Outbound Connector",
    version = 1,
    description = "Invoke HTTP requests for happy pictures of cats and dogs",
    icon = "dog_cat.svg",
    propertyGroups = {
      @ElementTemplate.PropertyGroup(id = "authentication", label = "Authentication"),
      @ElementTemplate.PropertyGroup(id = "endpoint", label = "Dog or Cat"),
      @ElementTemplate.PropertyGroup(id = "timeout", label = "Connection timeout"),
    },
    inputDataClass = HappyRequest.class)
@Slf4j
public class HappyHttpFunction implements OutboundConnectorFunction {

  private final HttpService httpService;

  public HappyHttpFunction() {
    this(ConnectorsObjectMapperSupplier.getCopy());
  }

  public HappyHttpFunction(final ObjectMapper objectMapper){
    this.httpService = new HttpService(objectMapper);
  }

  @Override
  public Object execute(OutboundConnectorContext context) throws IOException {
    final var connectorRequest = context.bindVariables(HappyRequest.class);
    return executeConnector(connectorRequest);
  }

  private List<HappyResponse> executeConnector(final HappyRequest connectorRequest) throws IOException {
    log.info("Executing my connector with request {}", connectorRequest);
    return httpService.executeHappyRequest(connectorRequest);
  }
}

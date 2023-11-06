package org.camunda.consulting;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.connector.feel.ConnectorsObjectMapperSupplier;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import org.camunda.consulting.auth.ApiKeyAuthentication;
import org.camunda.consulting.model.HappyRequest;
import org.camunda.consulting.model.HappyResponse;
import org.camunda.consulting.model.HappyUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyFunctionTest {

  private HappyHttpFunction happyHttpFunction;

  @BeforeEach
  public void setup() {
    happyHttpFunction = new HappyHttpFunction();
  }

  @Test
  void shouldReturnReceivedMessageWhenExecute() throws Exception {

    ObjectMapper objectMapper = ConnectorsObjectMapperSupplier.getCopy();
    // given
    var input = new HappyRequest(
            HappyUrl.CAT,
            new ApiKeyAuthentication("testKey"),
            0,
            null
    );
    var function = new HappyHttpFunction();
    var context = OutboundConnectorContextBuilder.create()
      .variables(objectMapper.writeValueAsString(input))
      .build();
    // when
    List<HappyRequest> result = (List<HappyRequest>) function.execute(context);
    // then
    assertThat(result)
            .isNotEmpty();
  }
}
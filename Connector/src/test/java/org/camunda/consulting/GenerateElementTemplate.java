package org.camunda.consulting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.connector.generator.core.OutboundElementTemplateGenerator;

public class GenerateElementTemplate {

    public static void main(String [] args) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(new OutboundElementTemplateGenerator().generate(HappyHttpFunction.class)));
    }
}

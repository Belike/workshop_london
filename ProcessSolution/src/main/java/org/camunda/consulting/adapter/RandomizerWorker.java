package org.camunda.consulting.adapter;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.extern.slf4j.Slf4j;
import org.camunda.consulting.services.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class RandomizerWorker {

    @Autowired
    ZeebeClient zeebeClient;


    RandomService randomService;
    @Autowired
    public RandomizerWorker(RandomService randomService){
        this.randomService = randomService;
    }

    @JobWorker(type = "retrieve-information-worker", autoComplete = true)
    public Map<String,Object> randomInteger(@Variable Integer min, @Variable Integer max, ActivatedJob job){
        int randomInt = randomService.randomInt(min, max);
        Map<String, Object> variables = new HashMap<>();
        variables.put("randomInt", randomInt);


        return variables;
    }

    @JobWorker(type = "logging")
    public void test(final ActivatedJob job){
        log.info("Current Activity is: {} of process instance id: {}" ,job.getElementId(), job.getBpmnProcessId());

    }
}

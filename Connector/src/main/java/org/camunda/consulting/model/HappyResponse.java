package org.camunda.consulting.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HappyResponse {

    private String id;
    private String url;
    private int width;
    private int height;
}

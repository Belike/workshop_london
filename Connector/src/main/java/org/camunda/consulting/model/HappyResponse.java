package org.camunda.consulting.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HappyResponse {

    public String id;
    public String url;
    public int width;
    public int height;
}

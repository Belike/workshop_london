package org.camunda.consulting.model;

import lombok.Getter;
import lombok.Setter;

public enum HappyUrl {
    CAT("https://api.thecatapi.com/v1/images/search"),
    DOG ("https://api.thedogapi.com/v1/images/search");

    public void setValue(String value) {
        if(value.equals("DOG")) this.value = HappyUrl.DOG.value;
        else {
            this.value = HappyUrl.CAT.value;
        }
    }
   @Getter
   @Setter
   private String value;

   HappyUrl(String value){
       this.value = value;
   }
}

package org.camunda.consulting.model;

import lombok.Getter;

public enum HappyUrl {
    CAT("https://api.thecatapi.com/v1/images/search"),
    DOG ("https://api.thedogapi.com/v1/images/search");

   @Getter
   public final String value;

   HappyUrl(String value){
       this.value = value;
   }

}

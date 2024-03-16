package com.decodenow.crud.dto;

import com.decodenow.crud.model.PersonalDetails;
import lombok.Data;

@Data
public class CustomResponse {
     private String message;
     private PersonalDetails data;

    public CustomResponse(String message, PersonalDetails data) {
        this.message = message;
        this.data = data;
    }

    public CustomResponse(String message){
        this.message= message;
    }
}

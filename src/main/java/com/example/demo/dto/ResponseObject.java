package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseObject{

    private String returnValue;
    private String pathString;
    private String user;
    private String password;
    private String alias;

}
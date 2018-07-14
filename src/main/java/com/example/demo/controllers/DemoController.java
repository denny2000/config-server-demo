package com.example.demo.controllers;

import com.example.demo.dto.ResponseObject;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@Controller
public class DemoController {

    @Value("${demo.return.value}")
    private String returnValue;

    @Value("${demo.user}")
    private String userName;

    @Value("${demo.password}")
    private String password;

    @Value("${demo.alias}")
    private String alias;

    @RequestMapping(path = "/test/{str}")
    public  ResponseEntity<ResponseObject> dynamicReturnValue(@PathVariable("str") String str){
        ResponseObject responseObject = ResponseObject
                .builder()
                .returnValue(returnValue)
                .pathString(str)
                .user(userName)
                .password(password)
                .alias(alias)
                .build();
        return ResponseEntity.ok(responseObject);

    }


}

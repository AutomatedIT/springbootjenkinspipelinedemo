package com.aits.cicdjenkinsspringbootdemo.web;

import org.springframework.web.bind.annotation.RequestMapping;

public class AITSController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}

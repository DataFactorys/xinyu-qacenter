package com.xinyi.xinyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 10067610 on 2018/7/17.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "sayhello", method = RequestMethod.GET)
    public String sayhello() {
        return "Hello SpringBoot !";
    }
}

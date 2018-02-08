package com.ysf.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by yangshunfan
 * 2018/2/8 15:06
 */
@RestController
public class HelloWorld {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World!!! create by ysf!!";
    }
}

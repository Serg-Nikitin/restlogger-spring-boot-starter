package ru.nikitin.testservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //    @ResponseBody
    @GetMapping(value = "/{id}")
    public String test(Integer id) {
        String result = String.format("success = %d", ++id);
        System.out.println(result);
        return result;
    }

}

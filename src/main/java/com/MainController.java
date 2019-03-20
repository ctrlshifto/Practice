package com;

import model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/20 12:42
 * @Modified by:
 */
@RestController
public class MainController {
    private Person person = new Person("yitian", 10000, LocalDate.of(1994, 1, 1));

    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/json", produces = "application/json")
    @ResponseBody
    public Person json() {
        return person;
    }
}


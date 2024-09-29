package com.springmvcthymealeaf.thymealeafdemo.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String hello(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDate.now().toString());

        return "helloworld";//Thymeleaf will look for helloworld.html file in templates
    }
}

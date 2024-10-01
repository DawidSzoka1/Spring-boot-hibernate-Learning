package com.springmvcthymeleaf.validationdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DemoController {

    @GetMapping("/testInit")
    public String testInit(Model model) {
        model.addAttribute("customer", new Customer());
        return "testInit";
    }

    @PostMapping("/testInit")
    public String testInitPost(@ModelAttribute("customer") Customer customer) {

        return "testInit-post";
    }
}

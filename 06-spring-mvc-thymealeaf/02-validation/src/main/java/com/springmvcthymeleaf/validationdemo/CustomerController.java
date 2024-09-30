package com.springmvcthymeleaf.validationdemo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String customer(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer";
    }

    @PostMapping("/customer")
    public String customerPost(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            return "customer";
        }
        return "customer-post";
    }
}

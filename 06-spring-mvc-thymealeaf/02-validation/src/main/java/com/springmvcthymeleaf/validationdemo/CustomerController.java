package com.springmvcthymeleaf.validationdemo;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String customer(Model model) {
        //this still work cus constructor dont check if the value is valid
        Customer c = new Customer("as", "asd", 20);

        model.addAttribute("customer", c);
        System.out.println(c);

        return "customer";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    //take every input and process it here working only in this Controller
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //delete extra white space
        // if only white space then null
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, trimmerEditor);
    }

    @PostMapping("/customer")
    public String customerPost(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult // results of validation
    ) {
        System.out.println(customer);
        if(bindingResult.hasErrors()) {
            return "customer";
        }
        return "customer-post";
    }
}

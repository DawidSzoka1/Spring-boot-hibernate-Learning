package com.springmvcthymealeaf.thymealeafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {


    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    @RequestMapping("/processFromVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        String name = "Yo! " + request.getParameter("studentName").toUpperCase();
        model.addAttribute("studentName", name);

        return "helloworld2";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld2";
    }

}

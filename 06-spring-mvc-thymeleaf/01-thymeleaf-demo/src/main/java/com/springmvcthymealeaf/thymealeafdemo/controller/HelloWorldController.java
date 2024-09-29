package com.springmvcthymealeaf.thymealeafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    @RequestMapping("/processFromVersionTwo")
    public String processFromVersionTwo(@RequestParam("studentName") String name, Model model){
        model.addAttribute("name", name.toUpperCase());
        return "helloworld2";
    }

//    @RequestMapping("/processFromVersionTwo")
//    public String letsShoutDude(HttpServletRequest request, Model model){
//        String name = "Yo! " + request.getParameter("studentName").toUpperCase();
//        model.addAttribute("studentName", name);
//
//        return "helloworld2";
//    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld2";
    }

}

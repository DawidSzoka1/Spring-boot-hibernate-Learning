package com.springmvcthymealeaf.thymealeafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");
        // if there isnt parameter called s then the value is null
        if(name != null){
            model.addAttribute("name", name.toUpperCase() + " formv3");

        }else {
            model.addAttribute("name", "no value");
        }
        return "helloworld3";
    }

}

package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

    @GetMapping("/")
    public String greeting(Model model) {
            model.addAttribute("name","ну допустим это просто");
        return "index";
    }
  @GetMapping("/calcpost")
    public String calcpost(Model model) {
       // model.addAttribute("name","ну допустим это просто");
        return "KalkulPost";
    }


    @PostMapping("/calcpost")
    public String calcpost(
            @RequestParam(
                    value = "num_1",
                    required = false,
                    defaultValue = "1") double first,
            @RequestParam(
                    value = "num_2",
                    required = false,
                    defaultValue = "1") double second,
            @RequestParam(
                    value = "objectiv",
                    required = false,
                    defaultValue = "1") String obj,
            Model model) {
        double res = 0;
        //String test = first + second + obj;
        switch (obj){
            case ("/"):
                res = first/second;
                break;
            case ("*"):
                res = first*second;
                break;
            case ("+"):
                res = first+second;
                break;
            case ("-"):
                res = first-second;
                break;
        }
        model.addAttribute("res",res);

        return "res";
    }

    @GetMapping("/calc")
    public String calc(
            @RequestParam(
                    value = "num_1",
                    required = false,
            defaultValue = "1") double first,
            @RequestParam(
                    value = "num_2",
                    required = false,
                    defaultValue = "1") double second,
            @RequestParam(
                    value = "objectiv",
                    required = false,
                    defaultValue = "1") String obj,
            Model model) {

        double res = 0;
        //String test = first + second + obj;

        switch (obj){
            case ("/"):
                res = first/second;
                break;
            case ("*"):
                res = first*second;
                break;
            case ("+"):
                res = first+second;
                break;
            case ("-"):
                res = first-second;
                break;
        }
        model.addAttribute("result",res);

        return "kalkul";
    }





}
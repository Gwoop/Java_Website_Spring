package com.example.demo.controllers;


import com.example.demo.models.Practics;
import com.example.demo.pacege.Prrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pr")
public class PrController {

    @Autowired
    private Prrepository prrepository;


    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Practics> pr = prrepository.findAll();
        model.addAttribute("pr",pr);
        return "pr/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "pr/add-pr";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("name") String name,
            @RequestParam("predmet") String predmet,
            @RequestParam("prepod") String prepod,
            @RequestParam("data") String data,
            @RequestParam("kolvo") int kolvo,
            Model model)
    {
        Practics pr = new Practics(name,predmet,prepod,data,kolvo);

        prrepository.save(pr);
        return "redirect:/pr/add";
    }


    @GetMapping("/search")
    public String add(
            @RequestParam("name") String name,
            Model model)
    {

        List<Practics> practics = prrepository.findByNameContains(name);

        model.addAttribute("pr",practics);
        return "pr/index";
    }


}

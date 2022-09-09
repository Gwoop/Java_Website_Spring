package com.example.demo.controllers;


import com.example.demo.models.Films;
import com.example.demo.models.Practics;
import com.example.demo.pacege.Prrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model)
    {
        Optional<Practics> practics = prrepository.findById(id);
        ArrayList<Practics> newsArrayList = new ArrayList<>();
        practics.ifPresent(newsArrayList::add);
        model.addAttribute("pr",newsArrayList);
        return "pr/info-pr";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {
        Practics practics = prrepository.findById(id).orElseThrow();
        prrepository.delete(practics);
        return "redirect:/pr/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!prrepository.existsById(id)) return "redirect:/pr/";

        Optional<Practics> practics = prrepository.findById(id);
        ArrayList<Practics> practicsArrayList = new ArrayList<>();
        practics.ifPresent(practicsArrayList::add);
        model.addAttribute("pr",practicsArrayList);
        return "pr/edit-pr";
    }
    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("predmet") String predmet,
                           @RequestParam("prepod") String prepod,
                           @RequestParam("data") String data,
                           @RequestParam("kolvo") Integer kolvo, Model model)
    {
        Practics practics = prrepository.findById(id).orElseThrow();
        practics.setName(name);
        practics.setPredmet(predmet);
        practics.setPrepod(prepod);
        practics.setData(data);
        practics.setKolvo(kolvo);
        prrepository.save(practics);
        return "redirect:/pr/";
    }



}

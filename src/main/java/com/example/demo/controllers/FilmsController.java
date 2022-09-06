package com.example.demo.controllers;

import com.example.demo.models.Films;
import com.example.demo.models.News;
import com.example.demo.pacege.Filmsrepository;
import com.example.demo.pacege.Newrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Controller
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    private Filmsrepository newsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Films> films = newsRepository.findAll();
        //Iterable<Films> news = newsRepository.findAll();
        model.addAttribute("films",films);
        return "films/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "films/add-films";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("studio") String studio,
            @RequestParam("likes") Integer likes,
            @RequestParam("dislikes") Integer dislikes,
            Model model)
    {
        Films filmsone = new Films(name,description,studio,likes,dislikes);

        newsRepository.save(filmsone);
        return "redirect:/films/add";
    }


    @GetMapping("/search")
    public String add(
            @RequestParam("name") String title,
            Model model)
    {
        List<Films> films = newsRepository.findByName(title);
        model.addAttribute("films",films);
        return "films/index";
    }




}

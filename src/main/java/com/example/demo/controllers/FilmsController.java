package com.example.demo.controllers;

import com.example.demo.models.Films;
import com.example.demo.models.News;
import com.example.demo.pacege.Filmsrepository;
import com.example.demo.pacege.Newrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
            @ModelAttribute("films")
            @Valid Films newfilms,
            BindingResult bindingResult,
            Model model)
    {
        if(bindingResult.hasErrors()) return "films/add-films";


        newsRepository.save(newfilms);
        return "redirect:/films/";
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


    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model)
    {
        Optional<Films> films = newsRepository.findById(id);
        ArrayList<Films> newsArrayList = new ArrayList<>();
        films.ifPresent(newsArrayList::add);
        model.addAttribute("films",newsArrayList);
        return "films/info-films";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {
        Films films = newsRepository.findById(id).orElseThrow();
        newsRepository.delete(films);
        return "redirect:/films/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!newsRepository.existsById(id)){
            return "redirect:/films/";
        }
        Optional<Films> films = newsRepository.findById(id);
        ArrayList<Films> newsArrayList = new ArrayList<>();
        films.ifPresent(newsArrayList::add);
        model.addAttribute("films",newsArrayList.get(0));
        return "films/edit-films";
    }
    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id,@ModelAttribute("news") @Valid Films films,BindingResult bindingResult, Model model)
    {
        if (!newsRepository.existsById(id))  return "redirect:/films/";
        if (bindingResult.hasErrors())  return "films/edit-films";
        films.setId(id);
        newsRepository.save(films);
        return "redirect:/films/";
    }




}

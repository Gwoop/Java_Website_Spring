package com.example.demo.controllers;


import com.example.demo.models.News;
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
@RequestMapping("/news")
public class NewsController {


    @Autowired
    private Newrepository newsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<News> news = newsRepository.findAll();
        model.addAttribute("news",news);
        return "news/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "news/add-news";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("name") String name,
            @RequestParam("autor") String author,
            @RequestParam("text") String bodyText,
            @RequestParam("views") Integer views,
            @RequestParam("likes") Integer likes,
            Model model)
    {
        News newsOne = new News(name,bodyText,author,likes,views);
        newsRepository.save(newsOne);
        return "redirect:/news/add";
    }


    @GetMapping("/search")
    public String add(
            @RequestParam("name") String title,
            Model model)
    {

        List<News>  news = newsRepository.findByName(title);
        model.addAttribute("news",news);
        return "news/index";
    }



}

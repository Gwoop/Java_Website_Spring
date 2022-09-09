package com.example.demo.controllers;

import com.example.demo.models.News;
import com.example.demo.pacege.Newrepository;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        model.addAttribute("news",new News());
        return "news/add-news";
    }
   /* @PostMapping("/add")
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
    }*/
    @PostMapping("/add")
    public String add( @ModelAttribute("news") @Valid News news, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) return "/add-news";
        newsRepository.save(news);
        return "redirect:/news/add";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("name") String title,
            Model model)
    {

        List<News>  news = newsRepository.findByNameContains(title);
        model.addAttribute("news",news);
        return "news/index";
    }
    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model)
    {

        Optional<News> news = newsRepository.findById(id);
        ArrayList<News> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("news",newsArrayList);
        return "news/info-news";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {


        News news = newsRepository.findById(id).orElseThrow();
        newsRepository.delete(news);

        //newsRepository.deleteById(id);

        return "redirect:/news/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!newsRepository.existsById(id)){
            return "redirect:/news/";
        }
        Optional<News> news = newsRepository.findById(id);
        ArrayList<News> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("news",newsArrayList);
        return "news/edit-news";
    }
    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("autor") String author,
                           @RequestParam("text") String bodyText,
                           @RequestParam("views") Integer views,
                           @RequestParam("likes") Integer likes, Model model)
    {
        News news = newsRepository.findById(id).orElseThrow();
        news.setName(name);
        news.setAutor(author);
        news.setText(bodyText);
        news.setViews(views);
        news.setLikes(likes);
        newsRepository.save(news);
        return "redirect:/news/";
    }



}

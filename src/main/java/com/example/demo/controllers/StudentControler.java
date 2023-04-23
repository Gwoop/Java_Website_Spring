package com.example.demo.controllers;


import com.example.demo.models.Empl;
import com.example.demo.models.User;
import com.example.demo.pacege.StudentRepository;
import com.example.demo.pacege.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@PreAuthorize("hasAnyAuthority('USER')")
@RequestMapping("/student")

public class StudentControler {


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String all_user(Model model){


        Iterable<Empl> students = studentRepository.findAll();
        model.addAttribute("student",students);
        return "student/index";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model)
    {
        Optional<Empl> empl = studentRepository.findById(id);
        ArrayList<Empl> newsArrayList = new ArrayList<>();
        empl.ifPresent(newsArrayList::add);
        model.addAttribute("courses",newsArrayList);

        return "student/one";
    }


}

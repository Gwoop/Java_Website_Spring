package com.example.demo.controllers;


import com.example.demo.models.Person;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.pacege.PersonRepository;
import com.example.demo.pacege.UserRepository;
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
@RequestMapping("/admin")
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public class Admin {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String all_user(Model model){
        Iterable<User> pr = userRepository.findAll();
        model.addAttribute("user",pr);
        return "users/alluser";
    }

    @GetMapping("/edit/{id}")
    public String all_user(@PathVariable("id") Long id, Model model){
        Optional<User> user_raw =  userRepository.findById(id);
        ArrayList<User> userArrayList = new ArrayList<>();
        user_raw.ifPresent(userArrayList::add);
        model.addAttribute("user",userArrayList.get(0));


        Iterable<Person> person = personRepository.findAll();
        model.addAttribute("person",person);

        return "users/edit-user";
    }


    @PostMapping("/edit/{id}")
    public String edit_roles(@PathVariable("id") Long id,
                             @ModelAttribute("user") @Valid User user,Person person, BindingResult bindingResult, Model model)

    {
        if (!userRepository.existsById(id)){return "users:/alluser/";}
        if (bindingResult.hasErrors()){return "users/edir-user";}
        user.setId(id);
        person.setId(id);
        person.setUser(user);
        user.setPerson(person);
        user.setActive(true);
        userRepository.save(user);
        return "redirect:/admin/";
    }


}

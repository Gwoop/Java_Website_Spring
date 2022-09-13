package com.example.demo.controllers;


import com.example.demo.models.Address;
import com.example.demo.models.Person;
import com.example.demo.models.Student;
import com.example.demo.models.University;
import com.example.demo.pacege.AddressRepository;
import com.example.demo.pacege.PersonRepository;
import com.example.demo.pacege.StudentRepository;
import com.example.demo.pacege.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/ManytoMany")
public class SveziController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public PersonRepository personRepository;

    @GetMapping("/person")
    private String Main(Model model){
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        Iterable<University> universities = universityRepository.findAll();
        model.addAttribute("universities", universities);

        return "relay/person";
    }

    @PostMapping("/person/add")
    public String blogPostAdd(@RequestParam String student, @RequestParam String universiti, Model model)
    {
        Student student2 = studentRepository.findByName(student);
        University university2 = universityRepository.findByName(universiti);
        student2.getUniversities().add(university2);
        university2.getStudents().add(student2);
        studentRepository.save(student2);
        universityRepository.save(university2);
        return "relay/person";
    }



    @GetMapping("/person1")
    public String Main1(Model model){
        Iterable<Address> address = addressRepository.findAll();
        model.addAttribute("address",address);
        return "relay/person1";
    }

    @PostMapping("/person1/add")
    public String blogPostAdd1(@RequestParam String name, @RequestParam String street, Model model)
    {
        Address adress = addressRepository.findByStreet(street);
        Person person = new Person(name, adress);
        personRepository.save(person);
        return "relay/person1";
    }

}

package com.example.demo.pacege;

import com.example.demo.models.Person;
import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Long> {

    public List<Person> findByUser_id(Long id);

}

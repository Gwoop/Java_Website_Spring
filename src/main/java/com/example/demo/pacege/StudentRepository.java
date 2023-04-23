package com.example.demo.pacege;

import com.example.demo.models.Empl;
import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Empl,Long> {



}

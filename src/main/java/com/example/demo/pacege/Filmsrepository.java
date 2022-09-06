package com.example.demo.pacege;

import com.example.demo.models.Films;

import com.example.demo.models.News;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Filmsrepository extends CrudRepository<Films,Long> {


    public List<Films> findByName(String Name);


}

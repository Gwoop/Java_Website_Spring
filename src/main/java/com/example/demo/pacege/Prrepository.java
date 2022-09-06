package com.example.demo.pacege;

import com.example.demo.models.News;
import com.example.demo.models.Practics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Prrepository extends CrudRepository<Practics,Long> {

    public List<Practics> findByName(String Name);
    public List<Practics> findByNameContains(String Name);

}

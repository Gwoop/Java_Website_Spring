package com.example.demo.pacege;

import com.example.demo.models.News;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Newrepository extends CrudRepository<News,Long> {



        public List<News> findByTytle(String tytle);
        public List<News> findByCaptnes(String tytle);

}

package com.example.demo.pacege;

import com.example.demo.models.Pasport;
import org.springframework.data.repository.CrudRepository;

public interface PasportRepository extends CrudRepository<Pasport, Long> {
    Pasport findByNumber(String number);
}

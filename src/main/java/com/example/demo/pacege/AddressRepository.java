package com.example.demo.pacege;

import com.example.demo.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Address findByStreet(String street);
}

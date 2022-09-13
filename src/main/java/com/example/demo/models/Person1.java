package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class Person1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    private Pasport pasport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pasport getPasport() {
        return pasport;
    }

    public void setPasport(Pasport pasport) {
        this.pasport = pasport;
    }

    public Person1(String name, Pasport pasport) {
        this.name = name;
        this.pasport = pasport;
    }

    public Person1() {
    }
}


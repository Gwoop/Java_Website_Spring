package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "pasports")
public class Pasport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String series;
    private String number;
    @OneToOne(optional = true, mappedBy = "pasport")
    private Person1 owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person1 getOwner() {
        return owner;
    }

    public void setOwner(Person1 owner) {
        this.owner = owner;
    }
}



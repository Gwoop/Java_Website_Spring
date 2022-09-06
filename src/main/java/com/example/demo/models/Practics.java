package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Practics {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name,predmet,prepod,data;
    int kolvo;


    public Practics() {

    }

    public Practics(String name, String predmet, String prepod, String data, int kolvo) {
        this.name = name;
        this.predmet = predmet;
        this.prepod = prepod;
        this.data = data;
        this.kolvo = kolvo;
    }

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

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getPrepod() {
        return prepod;
    }

    public void setPrepod(String prepod) {
        this.prepod = prepod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }
}

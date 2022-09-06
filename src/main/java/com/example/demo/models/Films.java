package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name,dicription,studio;
    int likes;
    int dislikes;

    public Films() {

    }


    public Films(String name, String dicription, String studio, int likes, int dislikes) {
        this.name = name;
        this.dicription = dicription;
        this.studio = studio;
        this.likes = likes;
        this.dislikes = dislikes;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDicription() {
        return dicription;
    }

    public String getStudio() {
        return studio;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDicription(String dicription) {
        this.dicription = dicription;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }


}

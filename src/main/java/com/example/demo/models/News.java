package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
    String name,text,autor;
    int likes;
    int views;


    public News() {

    }


    public News(String name, String text, String autor, int likes, int views) {
        this.name = name;
        this.text = text;
        this.autor = autor;
        this.likes = likes;
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}

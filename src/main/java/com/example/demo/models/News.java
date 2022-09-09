package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class News {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
   /* String name,text,autor;
    int likes;
    int views;*/
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 1000)
    String name;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 1000)
    String text;
    @NotNull(message = "Поле не может быть пустым")
    String autor;
    @Min(message = "Число не может быть отрицательным",value = 0)
    @Max(message = "Число не может быть отрицательным", value = 1000)
    @NotNull (message = "Обязательно к заполнению")
    Integer views,likes;



    public News() {

    }


    public News(String name, String text, String autor, Integer views, Integer likes) {
        this.name = name;
        this.text = text;
        this.autor = autor;
        this.views = views;
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}

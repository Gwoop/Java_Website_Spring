package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 50)
    private String fio;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 10,max = 50)
    private String nunmer;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 50)
    private String email;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 50)
    private String describe;



    private boolean active;



}

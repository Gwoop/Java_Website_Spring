package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




//

//Этот класс и все классы в папке model овечают за создание таблиз в бд и валидацию

//
@Entity
public class Empl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 30)
    private String fio;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 30)
    private String num;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 30)
    private String emal;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 80)
    private String des;

    public Empl() {
    }

    public Empl(String fio, String num, String emal, String des) {
        this.fio = fio;
        this.num = num;
        this.emal = emal;
        this.des = des;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

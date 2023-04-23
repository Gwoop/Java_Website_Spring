package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Empl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    private String num;

    private String emal;

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

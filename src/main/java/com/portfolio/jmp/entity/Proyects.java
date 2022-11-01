/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jmp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePryct;
    private String descPryct;
    private String imgPryct;

    public Proyects() {
    }

    public Proyects(String nombrePryct, String descPryct, String imgPryct) {
        this.nombrePryct = nombrePryct;
        this.descPryct = descPryct;
        this.imgPryct = imgPryct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePryct() {
        return nombrePryct;
    }

    public void setNombrePryct(String nombrePryct) {
        this.nombrePryct = nombrePryct;
    }

    public String getDescPryct() {
        return descPryct;
    }

    public void setDescPryct(String descPryct) {
        this.descPryct = descPryct;
    }

    public String getImgPryct() {
        return imgPryct;
    }

    public void setImgPryct(String imgPryct) {
        this.imgPryct = imgPryct;
    }


}

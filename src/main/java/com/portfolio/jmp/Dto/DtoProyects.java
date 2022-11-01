/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jmp.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author uy
 */
public class DtoProyects {
    
    private String imgPryct;
    @NotBlank
    private String nombrePryct;
    @NotBlank
    private String descPryct;

    public DtoProyects() {
    }

    public DtoProyects(String nombrePryct, String descPryct, String imgPryct) {
        this.nombrePryct = nombrePryct;
        this.descPryct = descPryct;
        this.imgPryct = imgPryct;
    }
    
        public DtoProyects(String nombrePryct, String descPryct) {
        this.nombrePryct = nombrePryct;
        this.descPryct = descPryct;
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

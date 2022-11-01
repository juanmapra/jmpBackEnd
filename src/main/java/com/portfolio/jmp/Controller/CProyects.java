/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jmp.Controller;

import com.portfolio.jmp.Dto.DtoProyects;
import com.portfolio.jmp.Security.Controller.Mensaje;
import com.portfolio.jmp.Service.SProyects;
import com.portfolio.jmp.entity.Proyects;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author uy
 */
@RestController
@RequestMapping("/proyects")
@CrossOrigin(origins = "https://jmpfrontend.web.app")
public class CProyects {
    @Autowired
    SProyects sPryct;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyects>> list(){
        List<Proyects> list = sPryct.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyects> getById(@PathVariable("id")int id){
        if(!sPryct.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
        }
        
        Proyects educacion = sPryct.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPryct.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
                }
        sPryct.delete(id);
        return new ResponseEntity(new Mensaje("Proyects eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyects dtopryct){
        if(StringUtils.isBlank(dtopryct.getNombrePryct())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(sPryct.existsByNombrePryct(dtopryct.getNombrePryct())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        Proyects proyects = new Proyects(dtopryct.getNombrePryct(),dtopryct.getDescPryct(),dtopryct.getImgPryct());
        sPryct.save(proyects);
        return new ResponseEntity(new Mensaje("Proyecto creado"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyects dtopryct){
        if(!sPryct.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
        }
        if(sPryct.existsByNombrePryct(dtopryct.getNombrePryct()) && sPryct.getByNombrePryct(dtopryct.getNombrePryct()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopryct.getNombrePryct())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacion"),HttpStatus.BAD_REQUEST);
        }
        
        Proyects proyects = sPryct.getOne(id).get();
        
        proyects.setNombrePryct(dtopryct.getNombrePryct());
        proyects.setDescPryct(dtopryct.getDescPryct());
        proyects.setImgPryct(dtopryct.getImgPryct());
        
        sPryct.save(proyects);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"),HttpStatus.OK);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jmp.Service;

import com.portfolio.jmp.entity.Proyects;
import com.portfolio.jmp.repository.RProyects;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyects {
    @Autowired
    RProyects rPryct;
    
    public List<Proyects> list(){
        return rPryct.findAll();
    }
    
    public Optional<Proyects> getOne(int id){
        return rPryct.findById(id);
    }
    
    public Optional<Proyects> getByNombrePryct(String nombrePryct){
        return rPryct.findByNombrePryct(nombrePryct);
    }
    
    public void save(Proyects proyects){
        rPryct.save(proyects);
    }
    
    public void delete(int id){
        rPryct.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPryct.existsById(id);
    }
    
    public boolean existsByNombrePryct(String nombrePryct){
        return rPryct.existsByNombrePryct(nombrePryct);
    }
}

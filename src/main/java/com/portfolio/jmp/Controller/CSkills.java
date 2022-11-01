/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jmp.Controller;

import com.portfolio.jmp.Dto.DtoSkills;
import com.portfolio.jmp.Security.Controller.Mensaje;
import com.portfolio.jmp.Service.SSkills;
import com.portfolio.jmp.entity.Skills;
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

@RestController
@CrossOrigin(origins = "https://jmpfrontend.web.app")
@RequestMapping("/skills")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoskills) {
        if (StringUtils.isBlank(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sSkills.existsByNombre(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoskills.getNombre(), dtoskills.getPorcentaje());
        sSkills.save(skills);

        return new ResponseEntity(new Mensaje("Skill agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoskills) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (sSkills.existsByNombre(dtoskills.getNombre()) && sSkills.getByNombre(dtoskills.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = sSkills.getOne(id).get();
        skills.setNombre(dtoskills.getNombre());
        skills.setPorcentaje(dtoskills.getPorcentaje());

        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}

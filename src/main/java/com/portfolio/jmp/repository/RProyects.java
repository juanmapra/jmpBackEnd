/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.jmp.repository;

import com.portfolio.jmp.entity.Proyects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author uy
 */
@Repository
public interface RProyects extends JpaRepository<Proyects, Integer> {
    public Optional<Proyects> findByNombrePryct(String nombrePryct);
    public boolean existsByNombrePryct(String nombrePryct);
}

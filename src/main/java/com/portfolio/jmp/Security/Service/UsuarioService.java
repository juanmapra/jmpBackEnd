/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jmp.Security.Service;

import com.portfolio.jmp.Security.Entity.Usuario;
import com.portfolio.jmp.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author uy
 */
@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return iUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
}

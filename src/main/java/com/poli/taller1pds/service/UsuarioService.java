package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.service.DTO.UsuarioInDTO;

import java.util.List;

public interface UsuarioService {

    Usuario save(UsuarioInDTO usuario);

    List<Usuario> findAll();

    void deleteById(Integer id);

    Usuario updateUser(Usuario usuario);

}

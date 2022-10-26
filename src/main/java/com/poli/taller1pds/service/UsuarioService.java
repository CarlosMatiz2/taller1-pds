package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    void deleteById(Integer id);

    Usuario updateUser(Usuario usuario);

}

package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.persistance.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }
}

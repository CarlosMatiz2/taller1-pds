package com.poli.taller1pds.controller;

import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.service.DTO.UsuarioInDTO;
import com.poli.taller1pds.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody UsuarioInDTO usuarioInDTO){
        return usuarioService.save(usuarioInDTO);
    }

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        usuarioService.deleteById(id);
    }

    @PutMapping
    public Usuario updateUser(@RequestBody Usuario usuario){
        return usuarioService.updateUser(usuario);
    }

}

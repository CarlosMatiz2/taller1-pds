package com.poli.taller1pds.mapper;

import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.service.DTO.UsuarioInDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInDTOToUsuario implements IMapper<UsuarioInDTO, Usuario>{
    @Override
    public Usuario map(UsuarioInDTO in) {
        Usuario usuario = new Usuario();
        usuario.setFecha_nacimiento(in.getFecha_nacimiento());
        usuario.setActivo(in.getActivo());
        usuario.setDependencia(in.getDependencia());
        usuario.setPerfil(in.getPerfil());
        usuario.setFilas(in.getFilas());
        return usuario;
    }
}

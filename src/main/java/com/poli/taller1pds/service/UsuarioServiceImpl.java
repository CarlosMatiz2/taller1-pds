package com.poli.taller1pds.service;

import com.poli.taller1pds.exceptions.UsuarioException;
import com.poli.taller1pds.mapper.TareaInDTOToTarea;
import com.poli.taller1pds.mapper.UsuarioInDTOToUsuario;
import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.persistance.repository.UsuarioRepository;
import com.poli.taller1pds.service.DTO.UsuarioInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;

    private final UsuarioInDTOToUsuario usuarioInDTOToUsuario;

    @Override
    public Usuario save(UsuarioInDTO usuarioInDTO) {
        if(getAge(usuarioInDTO.getFecha_nacimiento()) < 18){
            throw new UsuarioException("La edad del usuario debe ser mayor a 18 años", HttpStatus.BAD_REQUEST);
        }
        usuarioInDTO.setActivo(false);
        return repository.save(this.usuarioInDTOToUsuario.map(usuarioInDTO));
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Usuario updateUser(Usuario usuario) {
        Optional<Usuario> user = repository.findById(usuario.getId());
        user.get().setActivo(usuario.getActivo());
        if(getAge(usuario.getFecha_nacimiento()) < 18){
            throw new UsuarioException("La edad del usuario debe ser mayor a 18 años", HttpStatus.BAD_REQUEST);
        }
        user.get().setFecha_nacimiento(usuario.getFecha_nacimiento());
        return repository.save(user.get());
    }

    public int getAge(Date fecha_nacimiento) {
        LocalDate today = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha_nacimiento);
        int current_age =  today.getYear() - calendar.get(calendar.YEAR);
        return current_age;
    }

}

package com.poli.taller1pds.service;

import com.poli.taller1pds.mapper.TareaInDTOToTarea;
import com.poli.taller1pds.mapper.UsuarioInDTOToUsuario;
import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.persistance.repository.UsuarioRepository;
import com.poli.taller1pds.service.DTO.UsuarioInDTO;
import lombok.RequiredArgsConstructor;
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
        /*AtomicReference<Boolean> validateDuration = new AtomicReference<>(true);
        usuario.getFilas().forEach(element -> {
            if(longerDuration(25)){
                validateDuration.set(false);
                return;
            }
        });*/
        int current_age = getAge(usuarioInDTO.getFecha_nacimiento());
        Boolean validateDuration = longerDuration(25); // Falta saber como tomar la duration, lo de arriba es por q creo q tocaria recorrer todoo el arreglo.
        usuarioInDTO.setActivo(false);
        if(validations(validateDuration, current_age)) return repository.save(this.usuarioInDTOToUsuario.map(usuarioInDTO));
        return null;
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

    public boolean longerDuration(int duration) {
        if(duration >= 1 && duration <= 60) return true;
        return false;
    }

    public boolean validations(boolean duration, int current_age) {
        if (duration && current_age > 18) return true;
        return false;
    }
}

package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.persistance.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {
        /*AtomicReference<Boolean> validateDuration = new AtomicReference<>(true);
        usuario.getFilas().forEach(element -> {
            if(longerDuration(25)){
                validateDuration.set(false);
                return;
            }
        });*/
        int current_age = getAge(usuario.getFecha_nacimiento());
        Boolean validateDuration = longerDuration(25); // Falta saber como tomar la duration, lo de arriba es por q creo q tocaria recorrer todoo el arreglo.

        if(validations(validateDuration, current_age)) return repository.save(usuario);
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
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

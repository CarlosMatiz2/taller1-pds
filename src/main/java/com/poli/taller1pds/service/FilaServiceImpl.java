package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.persistance.repository.FilaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilaServiceImpl implements FilaService{

    private final FilaRepository repository;

    @Override
    public Fila save(Fila fila) {
        return repository.save(fila);
    }

    @Override
    public List<Fila> findAll() {
        return repository.findAll();
    }
}

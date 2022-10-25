package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.persistance.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService{

    private final TareaRepository repository;


    @Override
    public Tarea save(Tarea tarea) {
        return repository.save(tarea);
    }

    @Override
    public List<Tarea> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

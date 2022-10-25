package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Fila;

import java.util.List;

public interface FilaService {

    Fila save(Fila fila);

    List<Fila> findAll();

    void deleteById(Integer id);

}

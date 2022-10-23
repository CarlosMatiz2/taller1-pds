package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.service.DTO.FilaInDTO;

import java.util.List;

public interface FilaService {

    Fila save(FilaInDTO fila);

    List<Fila> findAll();

}

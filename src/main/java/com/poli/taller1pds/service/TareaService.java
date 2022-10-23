package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.service.DTO.TareaInDTO;

import java.util.List;

public interface TareaService {

    Tarea save(TareaInDTO tarea);

    List<Tarea> findAll();

}

package com.poli.taller1pds.service;

import com.poli.taller1pds.persistance.entity.Tarea;

import java.util.List;

public interface TareaService {

    Tarea save(Tarea tarea);

    List<Tarea> findAll();

}

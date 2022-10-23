package com.poli.taller1pds.mapper;

import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.service.DTO.TareaInDTO;
import org.springframework.stereotype.Component;

@Component
public class TareaInDTOToTarea implements IMapper<TareaInDTO, Tarea>{
    @Override
    public Tarea map(TareaInDTO in) {
        Tarea tarea = new Tarea();
        tarea.setNombre(in.getNombre());
        return tarea;
    }
}

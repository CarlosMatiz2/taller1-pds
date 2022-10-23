package com.poli.taller1pds.mapper;

import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.service.DTO.FilaInDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaInDTOToFila implements IMapper<FilaInDTO, Fila>{
    @Override
    public Fila map(FilaInDTO in) {
        Fila fila = new Fila();
        fila.setDuracion(in.getDuracion());
        fila.setTarea(in.getTarea());
        return fila;
    }
}

package com.poli.taller1pds.service.DTO;

import com.poli.taller1pds.persistance.entity.Tarea;
import lombok.Data;

@Data
public class FilaInDTO {
    private Tarea tarea;
    private Integer duracion;
}

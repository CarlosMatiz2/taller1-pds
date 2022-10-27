package com.poli.taller1pds.service.DTO;

import com.poli.taller1pds.persistance.entity.Dependencia;
import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.persistance.entity.Perfil;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
public class UsuarioInDTO {

    private Date fecha_nacimiento;
    private Boolean activo;
    private Dependencia dependencia;
    private Collection<Perfil> perfil;
    private Set<Fila> filas;
}

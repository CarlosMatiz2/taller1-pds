package com.poli.taller1pds.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "dependencia")
    private Dependencia dependencia;

   // @Column(name = "perfil")
   // private Perfil[] perfil;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Fila> filas;

}

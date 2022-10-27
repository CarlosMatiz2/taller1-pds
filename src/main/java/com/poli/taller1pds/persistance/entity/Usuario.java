package com.poli.taller1pds.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

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

    @ElementCollection(targetClass = Perfil.class)
    @Column(name = "perfil")
    @Enumerated(EnumType.STRING)
    private Collection<Perfil> perfil;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Fila> filas;

}

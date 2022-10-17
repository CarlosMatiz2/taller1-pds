package com.poli.taller1pds.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "filas")
public class Fila {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @JsonManagedReference
    @OneToOne(mappedBy = "fila", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Tarea tarea;

    @Column(name = "duracion")
    private Integer duracion;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}

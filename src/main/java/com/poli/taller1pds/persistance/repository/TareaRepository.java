package com.poli.taller1pds.persistance.repository;

import com.poli.taller1pds.persistance.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}

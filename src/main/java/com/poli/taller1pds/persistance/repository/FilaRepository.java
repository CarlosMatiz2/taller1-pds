package com.poli.taller1pds.persistance.repository;

import com.poli.taller1pds.persistance.entity.Fila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Integer> {
}

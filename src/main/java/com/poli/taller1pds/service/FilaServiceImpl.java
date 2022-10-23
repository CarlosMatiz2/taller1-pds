package com.poli.taller1pds.service;

import com.poli.taller1pds.mapper.FilaInDTOToFila;
import com.poli.taller1pds.mapper.TareaInDTOToTarea;
import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.persistance.repository.FilaRepository;
import com.poli.taller1pds.service.DTO.FilaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilaServiceImpl implements FilaService{

    private final FilaRepository filaRepository;

    private final FilaInDTOToFila filaInDTOToFila;

    @Override
    public Fila save(FilaInDTO filaInDTO) {
        return this.filaRepository.save(this.filaInDTOToFila.map(filaInDTO));
    }

    @Override
    public List<Fila> findAll() {
        return filaRepository.findAll();
    }
}

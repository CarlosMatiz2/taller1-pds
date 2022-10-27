package com.poli.taller1pds.service;

import com.poli.taller1pds.exceptions.FilaException;
import com.poli.taller1pds.mapper.FilaInDTOToFila;
import com.poli.taller1pds.mapper.TareaInDTOToTarea;
import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.persistance.repository.FilaRepository;
import com.poli.taller1pds.service.DTO.FilaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilaServiceImpl implements FilaService{

    private final FilaRepository filaRepository;

    private final FilaInDTOToFila filaInDTOToFila;

    @Override
    public Fila save(FilaInDTO filaInDTO) {
        if(filaInDTO.getDuracion() < 1 || filaInDTO.getDuracion() > 60){
            throw new FilaException("La duración debe ser un rango entre 1 a 60", HttpStatus.BAD_REQUEST);
        }
        return this.filaRepository.save(this.filaInDTOToFila.map(filaInDTO));
    }

    @Override
    public List<Fila> findAll() {
        return filaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        filaRepository.deleteById(id);
    }

    @Override
    public Fila updateFila(Fila fila) {
        if(fila.getDuracion() < 1 || fila.getDuracion() > 60){
            throw new FilaException("La duración debe ser un rango entre 1 a 60", HttpStatus.BAD_REQUEST);
        }
        Optional<Fila> filaOld = filaRepository.findById(fila.getId());
        filaOld.get().setDuracion(fila.getDuracion());
        System.out.println("Actualizando fila...");
        return filaRepository.save(filaOld.get());
    }
}

package com.poli.taller1pds.service;

import com.poli.taller1pds.mapper.TareaInDTOToTarea;
import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.persistance.repository.TareaRepository;
import com.poli.taller1pds.service.DTO.TareaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService{

    private final TareaRepository tareaRepository;

    private final TareaInDTOToTarea tareaInDTOToTarea;

    @Override
    public Tarea save(TareaInDTO tareaInDTO) {
        return this.tareaRepository.save(this.tareaInDTOToTarea.map(tareaInDTO));
    }

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        tareaRepository.deleteById(id);
    }
}

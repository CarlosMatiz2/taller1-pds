package com.poli.taller1pds.service;

import com.poli.taller1pds.mapper.TareaInDTOToTarea;
import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.persistance.repository.TareaRepository;
import com.poli.taller1pds.service.DTO.TareaInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Tarea updateTarea(Tarea tarea) {
        Optional<Tarea> task = tareaRepository.findById(tarea.getId());
        task.get().setNombre(tarea.getNombre());
        return tareaRepository.save(task.get());
    }



}

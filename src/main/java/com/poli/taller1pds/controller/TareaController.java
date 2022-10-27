package com.poli.taller1pds.controller;

import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.persistance.entity.Usuario;
import com.poli.taller1pds.service.DTO.TareaInDTO;
import com.poli.taller1pds.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    @PostMapping
    public Tarea createTarea(@RequestBody TareaInDTO tareaInDTO){
        return tareaService.save(tareaInDTO);
    }

    @GetMapping
    public List<Tarea> findAll(){
        return tareaService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        tareaService.deleteById(id);
    }

    @PutMapping
    public Tarea updateTarea(@RequestBody Tarea tarea) { return tareaService.updateTarea(tarea); }
}

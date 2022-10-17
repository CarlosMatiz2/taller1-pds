package com.poli.taller1pds.controller;

import com.poli.taller1pds.persistance.entity.Tarea;
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
    public Tarea createTarea(@RequestBody Tarea tarea){
        return tareaService.save(tarea);
    }

    @GetMapping
    public List<Tarea> findAll(){
        return tareaService.findAll();
    }

}

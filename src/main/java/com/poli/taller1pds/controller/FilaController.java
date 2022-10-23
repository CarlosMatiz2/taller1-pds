package com.poli.taller1pds.controller;

import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.service.FilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila")
@RequiredArgsConstructor
public class FilaController {

    private final FilaService filaService;

    @PostMapping
    public Fila createFila(@RequestBody Fila fila){
        return filaService.save(fila);
    }

    @GetMapping
    public List<Fila> findAll(){
        return filaService.findAll();
    }

}
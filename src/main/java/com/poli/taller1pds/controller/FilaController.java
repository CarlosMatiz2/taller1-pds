package com.poli.taller1pds.controller;

import com.poli.taller1pds.exceptions.FilaException;
import com.poli.taller1pds.persistance.entity.Fila;
import com.poli.taller1pds.persistance.entity.Tarea;
import com.poli.taller1pds.service.DTO.FilaInDTO;
import com.poli.taller1pds.service.FilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila")
@RequiredArgsConstructor
public class FilaController {

    private final FilaService filaService;

    @PostMapping
    public Fila createFila(@RequestBody FilaInDTO filaInDTO){
        return filaService.save(filaInDTO);
    }

    @GetMapping
    public List<Fila> findAll(){
        return filaService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        filaService.deleteById(id);
    }

    @PutMapping
    public Fila updateFila(@RequestBody Fila fila) { return filaService.updateFila(fila); }

}

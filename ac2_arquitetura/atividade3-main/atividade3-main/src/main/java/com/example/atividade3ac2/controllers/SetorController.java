package com.example.atividade3ac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade3ac2.dto.SetorDTO;
import com.example.atividade3ac2.services.SetorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/setor")
public class SetorController {
    
    @Autowired
    private SetorService setorService;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody SetorDTO setorDTO) {
        setorService.adicionar(setorDTO);
    }

    @GetMapping("/buscar/{idSetor}")
    public SetorDTO buscarSetorPorId(@PathVariable Integer idSetor) {
        return setorService.buscarSetorId(idSetor);
    }
}

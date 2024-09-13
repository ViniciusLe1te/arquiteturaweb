package com.example.ac1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Categorias;
import com.example.ac1.repositories.CategoriasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping("/api/Categorias")
public class CategoriasController {
    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping()
    public List<Categorias> getCategorias(){
        return categoriasRepository.obterTodos();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postCategorias(@RequestBody Categorias categorias) {
        categoriasRepository.salvar(categorias);
    }
    
}

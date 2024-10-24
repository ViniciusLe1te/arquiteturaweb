package com.example.atividade3ac2.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade3ac2.dto.ProjetoDTO;
import com.example.atividade3ac2.services.ProjetoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody ProjetoDTO projetoDto) {
        projetoService.adicionarProjeto(projetoDto);
    }
    
    @GetMapping("/buscar/{id}")
    public ProjetoDTO getPorId(@PathVariable Integer id) {
        return projetoService.buscarProjetoPorId(id);
    }
    
    @PostMapping("/vincularFuncionario/{idProjeto}/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping("/buscarEntreDatas/{dataInicio}/{dataFim}")
    public List<ProjetoDTO> getMethodName(@PathVariable LocalDate dataInicio, @PathVariable LocalDate dataFim) {
        return projetoService.buscarProjetosPorPeriodo(dataInicio, dataFim);
    }
    

}

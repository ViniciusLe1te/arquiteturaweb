package com.example.atividade3ac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade3ac2.dto.FuncionarioDTO;
import com.example.atividade3ac2.dto.ProjetoDTO;
import com.example.atividade3ac2.models.Projeto;
import com.example.atividade3ac2.services.FuncionarioService;
import com.example.atividade3ac2.services.FuncionarioServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public void adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.adicionar(funcionarioDTO);
    }
    
    @GetMapping("/buscarProjetos/{idFuncionario}")
    public List<ProjetoDTO> getProjetosPorFuncionario(@PathVariable Integer idFuncionario) {
        return funcionarioService.buscarProjetosPorFuncionarioId(idFuncionario);
    }
    
    
}

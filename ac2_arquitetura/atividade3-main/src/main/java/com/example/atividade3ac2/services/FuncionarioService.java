package com.example.atividade3ac2.services;

import java.util.List;

import com.example.atividade3ac2.dto.*;
import com.example.atividade3ac2.models.Funcionario;
public interface FuncionarioService {
    void adicionar(FuncionarioDTO funcionario);
    List<ProjetoDTO> buscarProjetosPorFuncionarioId(Integer idFuncionario);

    Funcionario buscarPorId(Integer idFuncionario);

}

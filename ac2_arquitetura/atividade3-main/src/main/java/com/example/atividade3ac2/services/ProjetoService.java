package com.example.atividade3ac2.services;

import java.time.LocalDate;
import java.util.List;

import com.example.atividade3ac2.dto.ProjetoDTO;
import com.example.atividade3ac2.models.Projeto;

public interface ProjetoService {
    void adicionarProjeto(ProjetoDTO projeto);
    void vincularFuncionario(Integer projetoId, Integer funcionarioId);
    ProjetoDTO buscarProjetoPorId(Integer id);
    List<ProjetoDTO> buscarProjetosPorPeriodo(LocalDate dataInicio, LocalDate dataFim);
}

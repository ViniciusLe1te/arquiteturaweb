package com.example.atividade3ac2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade3ac2.dto.FuncionarioDTO;
import com.example.atividade3ac2.dto.ProjetoDTO;
import com.example.atividade3ac2.models.Funcionario;
import com.example.atividade3ac2.models.Projeto;
import com.example.atividade3ac2.repositories.FuncionarioRepository;
import com.example.atividade3ac2.repositories.ProjetoRepository;
import com.example.atividade3ac2.repositories.SetorRepository;


@Service
public class ProjetoServiceImp implements ProjetoService{

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private SetorRepository setorRepository;
    @Override
    public void adicionarProjeto(ProjetoDTO projetoDto) {
        Projeto projeto = Projeto.builder()
        .descricao(projetoDto.getDescricao())
        .dataInicio(projetoDto.getDataInicio())
        .dataFim(projetoDto.getDataFim())
        .build();

        projetoRepository.save(projeto);
    }

    @Override
    public void vincularFuncionario(Integer projetoId, Integer funcionarioId) {
        Projeto projeto = projetoRepository.findById(projetoId).orElseThrow();
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow();

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
        funcionarioRepository.save(funcionario);
    }

    @Override
    public ProjetoDTO buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.findById(id).orElseThrow();

        return ProjetoDTO.builder()
            .descricao(projeto.getDescricao())
            .dataInicio(projeto.getDataInicio())
            .dataFim(projeto.getDataFim())
            .funcionarios(projeto.getFuncionarios().stream()
            .map(funcionario -> FuncionarioDTO.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .build())
                .collect(Collectors.toList()))
            .build();
    }

    @Override
    public List<ProjetoDTO> buscarProjetosPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {

        List<Projeto> projetos = projetoRepository.findProjetosByDataInicioBetween(dataInicio, dataFim);

        return projetos.stream().map((Projeto p) -> {


            return ProjetoDTO.builder()
            .id(p.getId())
            .descricao(p.getDescricao())
            .dataInicio(p.getDataInicio())
            .dataFim(p.getDataFim())
            .funcionarios(p.getFuncionarios().stream()
            .map(funcionario -> FuncionarioDTO.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .build())
                .collect(Collectors.toList()))
            .build();
        }).collect(Collectors.toList());
    }
    
}

package com.example.atividade3ac2.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.atividade3ac2.models.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoDTO {
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<FuncionarioDTO> funcionarios;

}

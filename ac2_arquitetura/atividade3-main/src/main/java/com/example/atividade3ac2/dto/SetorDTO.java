package com.example.atividade3ac2.dto;

import java.util.List;

import com.example.atividade3ac2.models.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetorDTO {
    private Integer id;
    private String nome;
    private List<Funcionario> funcionarios;
}

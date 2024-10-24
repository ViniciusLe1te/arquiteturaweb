package com.example.atividade3ac2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade3ac2.dto.SetorDTO;
import com.example.atividade3ac2.models.Setor;
import com.example.atividade3ac2.repositories.SetorRepository;

@Service
public class SetorServiceImp implements SetorService{

    @Autowired
    private SetorRepository setorRepository;
    
    @Override
    public void adicionar(SetorDTO setorD) {
        Setor setor = Setor.builder()
        .nome(setorD.getNome())
        .build();
        setorRepository.save(setor);
    }

    @Override
    public SetorDTO buscarSetorId(Integer id) {
        Setor setor = setorRepository.findById(id).orElseThrow();

        return SetorDTO.builder()
        .id(setor.getId())
        .nome(setor.getNome())
        .funcionarios(setor.getFuncionarios())
        .build();
    }
    
}

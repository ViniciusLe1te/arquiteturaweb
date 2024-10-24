package com.example.atividade3ac2.services;

import com.example.atividade3ac2.dto.SetorDTO;

public interface SetorService {
    void adicionar(SetorDTO setor);
    SetorDTO buscarSetorId(Integer id);
}

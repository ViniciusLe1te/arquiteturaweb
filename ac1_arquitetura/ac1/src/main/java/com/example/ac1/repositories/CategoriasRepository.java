package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Categorias;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriasRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categorias salvar(Categorias categorias) {
        categorias = entityManager.merge(categorias);
        return categorias;
    }

    public List<Categorias> obterTodos() {
        return entityManager
                .createQuery("from Categorias",Categorias.class).getResultList();
    }

    @Transactional
    public void excluir(Categorias categorias) {
        entityManager.remove(categorias);
    }

    public Categorias obterPorId(Integer categorias){
        return entityManager
            .find(Categorias.class, categorias);
    }
}

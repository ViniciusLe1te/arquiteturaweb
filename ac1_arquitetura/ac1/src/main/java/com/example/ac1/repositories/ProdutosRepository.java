package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produtos;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProdutosRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produtos salvar(Produtos produtos) {
        produtos = entityManager.merge(produtos);
        return produtos;
    }

    public List<Produtos> obterTodos() {
        return entityManager
                .createQuery("from Produtos",Produtos.class).getResultList();
    }

    @Transactional
    public void excluir(Produtos produtos) {
        entityManager.remove(produtos);
    }

    public Produtos obterPorId(int produtos){
        return entityManager.find(Produtos.class, produtos);
    }
}

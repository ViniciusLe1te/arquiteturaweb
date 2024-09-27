package com.example.ac1pt2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac1pt2.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    List<Categoria> findByNomeStartingWith(String nome);

    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produto WHERE c.id = :id")
    Categoria findCategoriaFetchProdutos(@Param("id") Long id);
}

package com.example.ac1pt2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac1pt2.models.Produto;
import java.util.List;


public interface ProdutoRepository  extends JpaRepository<Produto, Long>{
    @Query("SELECT p FROM Produto p WHERE p.preco > :valor")
    List<Produto> selecionarPrecoMaiorque(@Param("valor") Double valor);

    @Query("SELECT p FROM Produto p WHERE p.preco <= :valor")
    List<Produto> selecionarPrecomenorigual(@Param("valor") Double valor);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :nome%")
    List<Produto> selecionarNomeespecifico(@Param("nome") String nome);
}

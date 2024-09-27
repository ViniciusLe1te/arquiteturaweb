package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer produto;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer qtd;

    @ManyToOne
    @JoinColumn(name = "categoria.categoria", nullable = false)
    private Categorias categorias;

public Produtos(Integer produto, String nome, Integer qtd, Categorias categorias) {
        this.produto = produto;
        this.nome = nome;
        this.qtd = qtd;
        this.categorias = categorias;
    }


public Produtos() {
    }


public Integer getProduto() {
    return produto;
}
public void setProduto(Integer produto) {
    this.produto = produto;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public Integer getQtd() {
    return qtd;
}
public void setQtd(Integer qtd) {
    this.qtd = qtd;
}

public Categorias getCategorias() {
    return categorias;
}

public void setCategorias(Categorias categorias) {
    this.categorias = categorias;
}


@Override
public String toString() {
    return "Produtos [produto=" + produto + ", nome=" + nome + ", qtd=" + qtd + ", categorias=" + categorias + "]";
}





}

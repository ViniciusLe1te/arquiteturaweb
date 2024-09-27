package com.example.ac1.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoria;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categorias")
    private List<Produtos> produtos;

    public Categorias(Integer categoria, String nome, String descricao) {
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categorias() {
    }


    public Integer getCategoria() {
        return categoria;
    }
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Categorias [categoria=" + categoria + ", nome=" + nome + ", descricao=" + descricao + "]";
    }



}

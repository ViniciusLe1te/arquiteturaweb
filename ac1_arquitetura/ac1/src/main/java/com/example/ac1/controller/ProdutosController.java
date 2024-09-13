package com.example.ac1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Produtos;
import com.example.ac1.repositories.ProdutosRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/Produtos")
public class ProdutosController {
    @Autowired
    private ProdutosRepository produtosRepository;

    @PostMapping()
    public void postProdutos(@RequestBody Produtos produtos) {
        produtosRepository.salvar(produtos);
    }

    @GetMapping()
    public List<Produtos> getProdutos() {
        return produtosRepository.obterTodos();
    }

    @GetMapping("/:produto")
    public Produtos getProdutoId(@RequestParam Integer produto) {
        return produtosRepository.obterPorId(produto);
    }
    


}

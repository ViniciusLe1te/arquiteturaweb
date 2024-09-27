package com.example.ac1pt2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ac1pt2.models.Categoria;
import com.example.ac1pt2.models.Produto;
import com.example.ac1pt2.repositories.CategoriaRepository;
import com.example.ac1pt2.repositories.ProdutoRepository;

@SpringBootApplication
public class Ac1pt2Application {
	public CommandLineRunner init(
		@Autowired CategoriaRepository categoriaRepository,
		@Autowired ProdutoRepository produtoRepository){
			return args ->{
				Categoria eletronicos = new Categoria(null, "Eletrônicos");
        Categoria vestuario = new Categoria(null, "Vestuário");
        categoriaRepository.save(eletronicos); 
        categoriaRepository.save(vestuario);  

        produtoRepository.save(new Produto(null, "Celular", 1500.00, eletronicos));
        produtoRepository.save(new Produto(null, "Notebook", 3000.00, eletronicos));
        produtoRepository.save(new Produto(null, "Camiseta", 50.00, vestuario));

		// Buscar produtos maior que 1000
        System.out.println("Produtos com preço maior que 1000:");
        List<Produto> produtosCaros = produtoRepository.selecionarPrecoMaiorque(1000.00);
        produtosCaros.forEach(p -> System.out.println(p.getNome()));

		// Buscar produtos menor ou igual a 50
        System.out.println("Produtos com preço menor ou igual a 50:");
        List<Produto> produtosBaratos = produtoRepository.selecionarPrecomenorigual(50.00);
        produtosBaratos.forEach(p -> System.out.println(p.getNome()));

        // Buscar por nome que começa com 'C'
        System.out.println("Produtos que começam com 'C':");
        List<Produto> produtosComC = produtoRepository.selecionarNomeespecifico("C");
        produtosComC.forEach(p -> System.out.println(p.getNome()));

        // Buscar categorias que começam com 'E', que no caso seria 'Eletrônicos'
        System.out.println("Categorias que começam com 'E':");
        List<Categoria> categoriasComE = categoriaRepository.findByNomeStartingWith("E");
        categoriasComE.forEach(c -> System.out.println(c.getNome()));

        // Busca categoria com os produtos associados (eletrônicos)
        System.out.println("Categoria com produtos:");
        Categoria categoriaComProdutos = categoriaRepository.findCategoriaFetchProdutos(eletronicos.getId());
        categoriaComProdutos.getProduto().forEach(p -> System.out.println(p.getNome()));
			};
		}

	public static void main(String[] args) {
		SpringApplication.run(Ac1pt2Application.class, args);
	}

}

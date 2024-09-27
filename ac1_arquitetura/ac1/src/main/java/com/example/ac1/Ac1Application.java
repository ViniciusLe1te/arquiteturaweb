package com.example.ac1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categorias;
import com.example.ac1.models.Produtos;
import com.example.ac1.repositories.CategoriasRepository;
import com.example.ac1.repositories.ProdutosRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired CategoriasRepository categoriasRepository,
			@Autowired ProdutosRepository produtosRepository){
		return args -> {
			System.out.println("****CRIANDO AS CATEGORIAS***");
			Categorias c1 = categoriasRepository.salvar(
				new Categorias(0, "Mantimentos", "exatamente"));
			Categorias c2 = categoriasRepository.salvar(
				new Categorias(0, "Frutas", "frutinhas"));
			List<Categorias> lCategorias = categoriasRepository.obterTodos();
			lCategorias.forEach(System.out::println);

				System.out.println("****CRIANDO OS PRODUTOS***");
			produtosRepository.salvar(
				new Produtos(0, "Molho", 1, c1));
			produtosRepository.salvar(
				new Produtos(0, "Banana", 1, c2));
			List<Produtos> lProdutos = produtosRepository.obterTodos();
			lProdutos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}

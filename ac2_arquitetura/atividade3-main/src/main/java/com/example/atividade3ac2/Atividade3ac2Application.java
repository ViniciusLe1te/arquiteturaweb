package com.example.atividade3ac2;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade3ac2.models.Funcionario;
import com.example.atividade3ac2.models.Projeto;
import com.example.atividade3ac2.models.Setor;
import com.example.atividade3ac2.repositories.FuncionarioRepository;
import com.example.atividade3ac2.repositories.ProjetoRepository;
import com.example.atividade3ac2.repositories.SetorRepository;

@SpringBootApplication
public class Atividade3ac2Application {

	@Bean
    CommandLineRunner initDatabase(FuncionarioRepository funcionarioRepository,
                                   ProjetoRepository projetoRepository,
                                   SetorRepository setorRepository) {
        return args -> {
            // Criar alguns setores
            Setor setorTI = new Setor("Tecnologia da Informação");
            Setor setorRH = new Setor("Recursos Humanos");
            Setor setorFinanceiro = new Setor("Financeiro");
            setorRepository.saveAll(Arrays.asList(setorTI, setorRH, setorFinanceiro));

			System.out.println("Criou Setores");
            // Criar alguns funcionários
            Funcionario funcionario1 = new Funcionario("Carlos Silva", setorTI);
            Funcionario funcionario2 = new Funcionario("Maria Oliveira", setorRH);
            Funcionario funcionario3 = new Funcionario("João Souza", setorFinanceiro);
            funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2, funcionario3));
			System.out.println("Criou Funcionarios");
            // Criar alguns projetos
            Projeto projeto1 = new Projeto(1,"Sistema de Gestão", LocalDate.of(2024, 1, 10), LocalDate.of(2024, 12, 10));
            Projeto projeto2 = new Projeto("Projeto RH", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 8, 31));
            Projeto projeto3 = new Projeto("Automação Financeira", LocalDate.of(2024, 5, 5), LocalDate.of(2024, 10, 5));
            projetoRepository.saveAll(Arrays.asList(projeto1, projeto2, projeto3));
			System.out.println("Criou Projetos");

        };
	}
	public static void main(String[] args) {

		
		SpringApplication.run(Atividade3ac2Application.class, args);
	}

}

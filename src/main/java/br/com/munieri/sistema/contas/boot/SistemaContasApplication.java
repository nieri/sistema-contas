package br.com.munieri.sistema.contas.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("br.com.munieri.*")
@EntityScan("br.com.munieri.*")
@EnableJpaRepositories({"br.com.munieri.*"})
public class SistemaContasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaContasApplication.class, args);
	}
}

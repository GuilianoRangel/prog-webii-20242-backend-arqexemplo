package br.ueg.progweb2.arqexemplo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {
				"br.ueg.progweb2.arqexemplo.*",
				//Para funcionamento da Arquitetura
				"br.ueg.progweb2.arquitetura.*"}
)
@EntityScan(basePackageClasses = { Jsr310JpaConverters.class },
		basePackages = {
				"br.ueg.progweb2.arqexemplo.*",
				//Para funcionamento da Arquitetura
				"br.ueg.progweb2.arquitetura.*"}
)
@EnableJpaRepositories(basePackages = {
		"br.ueg.progweb2.arqexemplo.*",
		//Para funcionamento da Arquitetura
		"br.ueg.progweb2.arquitetura.*"
})
@OpenAPIDefinition(servers = {@Server(url = "${servidor.url}", description = "Default Server URL")})
public class ArqExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqExemploApplication.class, args);
	}

}

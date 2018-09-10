package br.com.avaliacaoJava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.avaliacaoJava.app.App;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("br.com.avaliacaoJava.dao")
@EntityScan(basePackages = { "br.com.avaliacaoJava.model" })
@ComponentScan(basePackages = { "br.com.avaliacaoJava" })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
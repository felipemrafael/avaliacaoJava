package br.com.avaliacaoJava.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avaliacaoJava.model.Endereco;


public interface EnderecoDao extends JpaRepository<Endereco, Long>{
	
	
}

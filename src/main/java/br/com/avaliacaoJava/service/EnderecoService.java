package br.com.avaliacaoJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacaoJava.dao.EnderecoDao;
import br.com.avaliacaoJava.model.Endereco;

@Service
public class EnderecoService{
	
	@Autowired
	private EnderecoDao enderecodao;
	
	public Endereco save(Endereco endereco) {
		return enderecodao.save(endereco);
	}
	
	public Optional<Endereco> findById(Long id) {
		return enderecodao.findById(id);
	}
	
	public List<Endereco> findAll() {
		return enderecodao.findAll();
	}
	
	public void delete(Endereco endereco) {
		enderecodao.delete(endereco);
	}

}

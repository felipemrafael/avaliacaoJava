package br.com.avaliacaoJava.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacaoJava.exception.NotFoundException;
import br.com.avaliacaoJava.model.Endereco;
import br.com.avaliacaoJava.service.EnderecoService;

@RestController
public class EnderecoController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EnderecoService enderecoService;
		
	
	
	@RequestMapping(value="/v2/endereco", method=RequestMethod.GET, 
	produces="application/json")
	public List<Endereco> listEnderecos(){		
		return enderecoService.findAll();		
	}
	
		
	@RequestMapping(value="/v2/endereco", method=RequestMethod.POST, 
    produces="application/json", consumes="application/json")
	public Endereco salvarEndereco(@RequestBody Endereco endereco){		
		return enderecoService.save(endereco);		
	}
	
		
	@RequestMapping(value="/v2/endereco/{id}", method=RequestMethod.GET, 
    produces="application/json")
	public Endereco getEnderecoById(@PathVariable(value = "id") Long idEndereco) {
	    return enderecoService.findById(idEndereco)
	            .orElseThrow(() -> new NotFoundException("Endereco", "id", idEndereco));
	}	
	
		
	@RequestMapping(value="/v2/endereco/{id}", method=RequestMethod.PUT, 
    produces="application/json", consumes="application/json")
	public Endereco atualizaEndereco(@PathVariable(value = "id") Long idEndereco,
									 @RequestBody Endereco enderecoEdit) {

	    Endereco endereco = enderecoService.findById(idEndereco)
	            .orElseThrow(() -> new NotFoundException("Endereco", "id", idEndereco));

	    endereco.setRua(enderecoEdit.getRua());
	    endereco.setNumero(enderecoEdit.getNumero());
	    endereco.setBairro(enderecoEdit.getBairro());
	    endereco.setComplemento(enderecoEdit.getComplemento());
	    endereco.setCep(enderecoEdit.getCep());
	    endereco.setCidade(enderecoEdit.getCidade());
	    endereco.setEstado(enderecoEdit.getEstado());

	    Endereco enderecoAtualizado = enderecoService.save(endereco);
	    return enderecoAtualizado;
	}	
	
	
	
	@RequestMapping(value="/v2/endereco/{id}", method=RequestMethod.DELETE, 
    produces="application/json")
	public ResponseEntity<?> deletarEndereco(@PathVariable(value = "id") Long idEndereco) {
	    Endereco endereco = enderecoService.findById(idEndereco)
	            .orElseThrow(() -> new NotFoundException("Endereco", "id", idEndereco));

	    enderecoService.delete(endereco);

	    return ResponseEntity.ok().build();
	}	
	
	
}

package br.com.avaliacaoJava.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.avaliacaoJava.app.App;
import br.com.avaliacaoJava.dao.EnderecoDao;
import br.com.avaliacaoJava.model.Endereco;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {App.class})
public class EnderecoServiceTest {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@MockBean
	private EnderecoDao enderecoDao;
	
	
	@Test
	public void saveEnderecoTest(){

		Endereco endereco1 = new Endereco();
		
		endereco1.setId(1L);
		endereco1.setRua("Rua 1");
		endereco1.setNumero(2);
		endereco1.setComplemento("Casa 5");
		endereco1.setBairro("Centro");
		endereco1.setCidade("São Paulo");
		endereco1.setEstado("Rio de Janeiro");
		
	    Mockito.when(enderecoDao.save(endereco1)).thenReturn(endereco1);
	    
	    assertThat(enderecoService.save(endereco1)).isEqualTo(endereco1);
	
	}
	
	
	@Test
	public void listEnderecosTest(){
		
		Endereco endereco1 = new Endereco();
		
		endereco1.setId(1L);
		endereco1.setRua("Rua 1");
		endereco1.setNumero(2);
		endereco1.setComplemento("Casa 5");
		endereco1.setBairro("Centro");
		endereco1.setCidade("São Paulo");
		endereco1.setEstado("Rio de Janeiro");
		
		Endereco endereco2 = new Endereco();
		
		endereco2.setId(2L);
		endereco2.setRua("Rua 2");
		endereco2.setNumero(10);
		endereco2.setComplemento("");
		endereco2.setBairro("Bairro");
		endereco2.setCidade("São Paulo");
		endereco2.setEstado("São Paulo");
		
		List<Endereco> listaEndereco = new ArrayList<>();
		listaEndereco.add(endereco1);
		listaEndereco.add(endereco2);
		
		Mockito.when(enderecoDao.findAll()).thenReturn(listaEndereco);
		
		assertThat(enderecoService.findAll()).isEqualTo(listaEndereco);
	}
	
	
	
}


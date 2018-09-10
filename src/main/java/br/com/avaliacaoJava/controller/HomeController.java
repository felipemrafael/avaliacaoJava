package br.com.avaliacaoJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.avaliacaoJava.service.EnderecoService;

@Controller
public class HomeController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping("/")
	public ModelAndView homeEndereco() {
		ModelAndView model = new ModelAndView("cadastroEndereco");
		
		model.addObject("listaEnderecos", enderecoService.findAll());
		
		return model;		
	}

}

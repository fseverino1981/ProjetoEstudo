package br.com.seanfla.webfenix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.seanfla.webfenix.repository.ClientesRepository;
import org.springframework.web.servlet.ModelAndView;
import br.com.seanfla.webfenix.model.ClienteModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/clientes/clienteslista")
public class ClientesController {
	
	@Autowired
	private ClientesRepository clientes;
	
	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView mv = new ModelAndView("/clientes/clienteslista");
		mv.addObject("clientes",clientes.findAll());
		mv.addObject(new ClienteModel());
		return mv;

	}
	
}

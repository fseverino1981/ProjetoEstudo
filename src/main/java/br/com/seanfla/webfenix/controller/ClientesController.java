package br.com.seanfla.webfenix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.seanfla.webfenix.repository.ClientesRepository;
import org.springframework.web.servlet.ModelAndView;
import br.com.seanfla.webfenix.model.ClienteModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/clientes")
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
	
	//Método que carrega página para create
	@GetMapping("/add")
	 public ModelAndView add(ClienteModel cliente) {
	         
	        ModelAndView mv = new ModelAndView("clientes/clientesman");
	        mv.addObject("cliente", cliente);
	         
	        return mv;
	 }
	
	//Método para salvar os registros na página
		@PostMapping("/save")
		 public ModelAndView save(@Valid ClienteModel cliente, BindingResult result) {
	        
	        if(result.hasErrors()) {
	            return add(cliente);
	        }
	         
	        clientes.save(cliente);
	         
	        return listar();
	    }
	
	//Método para editar registros da página
		@GetMapping("/edit/{id}")
		public ModelAndView Editar(@PathVariable("id") Long id) {
			
			return add(clientes.findOne(id));
		}	
		
		@GetMapping("/delete/{id}")
		public ModelAndView Deletar(@PathVariable("id") Long id) {
			
			clientes.delete(id);
			
			return listar();
			
		}
	
}

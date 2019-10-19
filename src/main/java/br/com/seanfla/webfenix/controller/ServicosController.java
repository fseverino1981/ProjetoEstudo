package br.com.seanfla.webfenix.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.seanfla.webfenix.model.ServicoModel;
import br.com.seanfla.webfenix.repository.ServicosRepository;

@Controller
@RequestMapping("/servicos")
public class ServicosController {
	
	@Autowired
	private ServicosRepository servicos;
	
	//Método de carga da lista de registros na página
	@GetMapping
	public ModelAndView listar() {
		
		
		ModelAndView mv = new ModelAndView("servicos/servicoslista");
		mv.addObject("servicos", servicos.findAll());
		mv.addObject(new ServicoModel());		
		return mv;

	}
	
	//Método que carrega página para create
	 @GetMapping("/add")
	 public ModelAndView add(ServicoModel servico) {
	         
	        ModelAndView mv = new ModelAndView("servicos/servicosman");
	        mv.addObject("servico", servico);
	         
	        return mv;
	 }
	
	//Método para salvar os registros na página
	@PostMapping("/save")
	 public ModelAndView save(@Valid ServicoModel servico, BindingResult result) {
        
        if(result.hasErrors()) {
            return add(servico);
        }
         
        servicos.save(servico);
         
        return listar();
    }
	
	//Método para editar registros da página
	@GetMapping("/edit/{id}")
	public ModelAndView Editar(@PathVariable("id") Long id) {
		
		return add(servicos.findOne(id));
	}	
	
	@GetMapping("/delete/{id}")
	public ModelAndView Deletar(@PathVariable("id") Long id) {
		
		servicos.delete(id);
		
		return listar();
		
	}

}

package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Funcionario;
import org.example.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class FuncionarioController {
	
	private final FuncionarioService service;

	@GetMapping()
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/funcionario/funcionarioList");
		mv.addObject("funcionarios", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Funcionario funcionario) {
		
		ModelAndView mv = new ModelAndView("/funcionario/funcionarioForm");
		mv.addObject("funcionario", funcionario);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id).get());
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	@PostMapping("/save")
	public ModelAndView save(Funcionario funcionario, BindingResult result) {

		if(result.hasErrors()) {
			return add(funcionario);
		}
		
		service.save(funcionario);

		return findAll();
	}
	
}

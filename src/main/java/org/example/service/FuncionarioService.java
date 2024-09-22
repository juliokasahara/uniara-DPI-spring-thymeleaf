package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Funcionario;
import org.example.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioService {
	
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll() {
		return repository.findAll(); 
	}
	
	public Optional<Funcionario> findOne(Long id) {
		return repository.findById(id);
	}
	
	public Funcionario save(Funcionario post) {
		return repository.saveAndFlush(post);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}

package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.controller.form.AutorForm;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.dto.AutorDTO;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.entity.Autor;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.repository.AutorRepository;

@RestController
@RequestMapping(value="/autores")
public class AutorController {
	
	@Autowired
	AutorRepository repository;
	
	@PostMapping
	public  ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorForm form) {
		Autor autor = new Autor(form);
		repository.save(autor);
		
		return ResponseEntity.ok(new AutorDTO(autor));
	}
}

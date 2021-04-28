package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/autores")
public class AutorController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public  ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest request) {
		Autor autor = request.toModel();
		manager.persist(autor);
		
		return ResponseEntity.ok(new AutorResponse(autor));
	}
}

package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest request) {
		this.validarEmail(request);
		
		Autor autor = request.toModel();
		repository.save(autor);
		
		return ResponseEntity.ok(new AutorResponse(autor));
	}
	
	private void validarEmail(AutorRequest request) {
		Optional<Autor> obj = repository.findByEmail(request.getEmail());
		if (obj.isPresent()) {
			throw new CadastradoEmailException("Email já cadastrado");
		}
	}
}

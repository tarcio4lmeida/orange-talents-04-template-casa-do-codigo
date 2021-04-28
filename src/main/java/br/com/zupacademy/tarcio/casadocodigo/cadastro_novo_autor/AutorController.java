package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@Autowired
	private ProibeEmailDuplicadoAutorValidator  proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest request) {
		Autor autor = request.toModel();
		repository.save(autor);
		
		return ResponseEntity.ok(new AutorResponse(autor));
	}

}

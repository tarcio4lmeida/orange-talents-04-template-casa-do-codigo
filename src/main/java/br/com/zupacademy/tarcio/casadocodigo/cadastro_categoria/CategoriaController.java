package br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria;

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
@RequestMapping(value="/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ProibeCategoriaComNomeDuplicadoValidator  proibeCategoriaComNomeDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeCategoriaComNomeDuplicadoValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaResponse> cadastrar(@RequestBody @Valid CategoriaRequest request) {
		Categoria categoria = request.toModel();
		repository.save(categoria);
		
		return ResponseEntity.ok(new CategoriaResponse(categoria));
	}

}

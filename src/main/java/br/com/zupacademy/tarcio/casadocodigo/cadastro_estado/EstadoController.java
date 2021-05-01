package br.com.zupacademy.tarcio.casadocodigo.cadastro_estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@RequestMapping(value="/estados")
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ProibeEstadoDuplicadoPeloMesmoPaisValidator  proibeEstadoDuplicadoPeloMesmoPaisValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEstadoDuplicadoPeloMesmoPaisValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoResponse> cadastrar(@RequestBody @Valid EstadoRequest request) {
		Estado estado = request.toModel(manager);
		manager.persist(estado);
		
		return ResponseEntity.ok(new EstadoResponse(estado));
	}

}

package br.com.zupacademy.tarcio.casadocodigo.cadastro_clientes;

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
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaisComEstadoValidator  paisComEstadoValidator;
	
	@Autowired
	private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(paisComEstadoValidator);
		binder.addValidators(estadoPertenceAoPaisValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequest request) {
		Cliente cliente = request.toModel(manager);
		manager.persist(cliente);
		
		return ResponseEntity.ok(request.getEstadoId() == null ? new ClienteResponseSemEstado(cliente) : new ClienteResponseComEstado(cliente));
	}

}

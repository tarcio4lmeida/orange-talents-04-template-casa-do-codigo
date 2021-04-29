package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/livros")
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest request) {
		Livro Livro = request.toModel(manager);
		manager.persist(Livro);
		
		return ResponseEntity.ok(new LivroResponse(Livro));
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping
	@Transactional
	public ResponseEntity<List<LivroListaDTO>> listaLivros(){
		List<Livro> list = manager.createQuery("Select t from " + Livro.class.getSimpleName() + " t").getResultList();
		
		return ResponseEntity.ok().body(list.stream().map(x-> new LivroListaDTO(x)).collect(Collectors.toList()));
	}
	

}

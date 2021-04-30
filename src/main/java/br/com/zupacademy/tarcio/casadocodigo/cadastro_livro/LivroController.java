package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		Livro livro = request.toModel(manager);
		manager.persist(livro);
		
		return ResponseEntity.ok(new LivroResponse(livro));
	}
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<LivroListaDTO>> listaLivros(){
		return ResponseEntity.ok().body(LivroListaDTO.toDTO(manager));
	}
	
	@GetMapping(value="/{id}")
	@Transactional
	public ResponseEntity<LivroDetalheDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(LivroDetalheDTO.toDTO(manager, id));
	}

}

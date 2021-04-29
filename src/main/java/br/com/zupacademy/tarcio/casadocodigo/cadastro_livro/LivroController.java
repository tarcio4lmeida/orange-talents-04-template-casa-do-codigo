package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria.CategoriaRepository;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.AutorRepository;

@RestController
@RequestMapping(value="/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest request) {
		Livro Livro = request.toModel(categoriarepository, autorRepository);
		repository.save(Livro);
		
		return ResponseEntity.ok(new LivroResponse(Livro));
	}

}

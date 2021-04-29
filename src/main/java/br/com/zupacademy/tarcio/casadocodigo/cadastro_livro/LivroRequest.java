package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria.Categoria;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria.CategoriaRepository;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.Autor;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.AutorRepository;
import br.com.zupacademy.tarcio.casadocodigo.config.validacao.UniqueValue;

public class LivroRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "O resgistro de {2} já está em uso")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@Min(value = 20)
	@Positive
	@NotNull
	private Double preco;
	
	@Positive
	@Min(value = 100)
	@NotNull
	private Integer qtdPaginas;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "O resgistro de {2} já está em uso")
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@NotNull
	private LocalDate dataPublicacao;
	
	@NotNull
	private Long categoriaId;
	
	@NotNull
	private Long autorId;
	
	@Deprecated
	public LivroRequest() {
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}
	
	public Livro toModel(CategoriaRepository categoriarepository, AutorRepository autorRepository) {
		return new Livro(
				 this.titulo,
				 this.resumo,
				 this.sumario,
				 this.preco,
				 this.qtdPaginas,
				 this.isbn,
				 this.dataPublicacao,
				 this.buscaCategoria(categoriarepository, categoriaId),
				 this.buscaAutor(autorRepository, autorId));
	}
		
	public Autor buscaAutor(AutorRepository autorRepository, Long id) {
		Optional<Autor> optAutor = autorRepository.findById(id);
		Autor autor  = optAutor.orElseThrow(() -> new RecursoNaoEncontradoException("Autor não encontrado"));

		return autor;
	}
	
	public  Categoria buscaCategoria(CategoriaRepository categoriarepository, Long id) {
		Optional<Categoria> optCategoria = categoriarepository.findById(id);
		Categoria cat  = optCategoria.orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada"));
		return cat;
	}

}

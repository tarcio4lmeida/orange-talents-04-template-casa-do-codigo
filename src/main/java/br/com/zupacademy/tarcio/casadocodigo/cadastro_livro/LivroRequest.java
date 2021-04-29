package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria.Categoria;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.Autor;
import br.com.zupacademy.tarcio.casadocodigo.config.validacao.ExistsId;
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
	@ExistsId(domainClass = Categoria.class, fieldName = "id", message = "O resgistro de {2} informado não existe!")
	private Long categoriaId;
	
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id", message = "O resgistro de {2} informado não existe!")
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
	
	public Livro toModel(EntityManager manager) {
		
		@NotNull Autor autor = manager.find(Autor.class, autorId);
		@NotNull Categoria categoria = manager.find(Categoria.class, categoriaId);
		
		Assert.state(autor!=null, "Você está querendo cadastrar um livro para um autor que não existe no banco" + autorId);
		Assert.state(autor!=null, "Você está querendo cadastrar um livro para uma categoria que não existe no banco" + categoriaId);

		return new Livro(
				 this.titulo,
				 this.resumo,
				 this.sumario,
				 this.preco,
				 this.qtdPaginas,
				 this.isbn,
				 this.dataPublicacao,
				 categoria,
				 autor);
	}
		

}

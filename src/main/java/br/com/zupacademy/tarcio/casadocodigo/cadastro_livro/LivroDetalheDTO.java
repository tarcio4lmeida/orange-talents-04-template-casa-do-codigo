package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroDetalheDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer qtdPaginas;
	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
	private DetalheSiteAutorResponse autor;

	@Deprecated
	public LivroDetalheDTO() {
	}

	public LivroDetalheDTO(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.qtdPaginas = livro.getQtdPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = new DetalheSiteAutorResponse(livro.getAutor());

	}
	
	public static LivroDetalheDTO toDTO(EntityManager manager, Long id) {
		Livro livro = manager.find(Livro.class, id);
		
		if(livro == null) {
			throw new RecursoNaoEncontradoException("O livro requistado não existe");
		}
		return new LivroDetalheDTO(livro);
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

	public DetalheSiteAutorResponse getAutor() {
		return autor;
	}

}

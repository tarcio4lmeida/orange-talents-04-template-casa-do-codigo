package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria.Categoria;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.Autor;

public class LivroResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer qtdPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Categoria categoria;
	private Autor autor;
	
	@Deprecated
	public LivroResponse() {
	}

	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.qtdPaginas = livro.getQtdPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();
						 
	}
	
	public Long getId() {
		return id;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	
}

package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria.Categoria;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.Autor;

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique=true)
	private String titulo;
	
	@Column(nullable = false, length = 500)
	private String resumo;
	
	@Column(columnDefinition = "text")
	private String sumario;
	
	private Double preco;
	
	@Column(nullable = false)
	private Integer qtdPaginas;
	
	@Column(nullable = false, unique=true)
	private String isbn;
	
	private LocalDate dataPublicacao;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {
	}

	public Livro(String titulo, String resumo, String sumario, double preco, Integer qtdPaginas, String isbn,
			LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.qtdPaginas = qtdPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
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

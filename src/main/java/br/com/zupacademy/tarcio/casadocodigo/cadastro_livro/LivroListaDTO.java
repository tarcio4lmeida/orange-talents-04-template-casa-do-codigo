package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;

public class LivroListaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;

	@Deprecated
	public LivroListaDTO() {
	}

	public LivroListaDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}

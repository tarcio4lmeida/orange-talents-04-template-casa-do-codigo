package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.Autor;

public class DetalheSiteAutorResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;

	public DetalheSiteAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
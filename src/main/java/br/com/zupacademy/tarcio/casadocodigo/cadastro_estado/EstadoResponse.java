package br.com.zupacademy.tarcio.casadocodigo.cadastro_estado;

import java.io.Serializable;

public class EstadoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	private DetalhePais pais;
	
	@Deprecated
	public EstadoResponse() {
	}
	
	public EstadoResponse(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.pais = new DetalhePais(estado.getPais());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public DetalhePais getPais() {
		return pais;
	}
	
	
}

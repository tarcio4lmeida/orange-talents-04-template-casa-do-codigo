package br.com.zupacademy.tarcio.casadocodigo.cadastro_pais;

import java.io.Serializable;

public class PaisResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	@Deprecated
	public PaisResponse() {
	}
	
	public PaisResponse(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}

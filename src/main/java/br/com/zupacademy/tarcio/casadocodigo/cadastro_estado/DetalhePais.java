package br.com.zupacademy.tarcio.casadocodigo.cadastro_estado;

import java.io.Serializable;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_pais.Pais;

public class DetalhePais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@Deprecated
	public DetalhePais() {
	}
	
	public DetalhePais(Pais pais) {
		this.nome = pais.getNome();
	}
	
	public String getNome() {
		return nome;
	}
	
}

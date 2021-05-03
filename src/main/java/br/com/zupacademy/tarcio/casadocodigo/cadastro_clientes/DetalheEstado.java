package br.com.zupacademy.tarcio.casadocodigo.cadastro_clientes;

import java.io.Serializable;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_estado.Estado;

public class DetalheEstado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@Deprecated
	public DetalheEstado() {
	}
	
	public DetalheEstado(Estado estado) {
		this.nome = estado.getNome();
	}
	
	public String getNome() {
		return nome;
	}
	
}

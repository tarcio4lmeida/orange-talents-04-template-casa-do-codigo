package br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CategoriaRequest {

	@NotBlank
	@Length(max = 50)
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
}

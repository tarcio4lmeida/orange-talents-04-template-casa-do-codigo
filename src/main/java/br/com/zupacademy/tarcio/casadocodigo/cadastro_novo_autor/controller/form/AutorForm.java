package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class AutorForm {

	@NotBlank
	@Length(max = 30)
	private String nome;

	@NotBlank
	@Email
	private String email;
	
	@Size(max = 400)
	@NotBlank
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	
}

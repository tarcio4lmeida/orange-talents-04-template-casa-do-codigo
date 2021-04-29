package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.tarcio.casadocodigo.config.validacao.UniqueValue;

public class AutorRequest {

	@NotBlank
	@Length(max = 30)
	private String nome;

	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "O valor do campo {0} já está em uso.")
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

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	
}

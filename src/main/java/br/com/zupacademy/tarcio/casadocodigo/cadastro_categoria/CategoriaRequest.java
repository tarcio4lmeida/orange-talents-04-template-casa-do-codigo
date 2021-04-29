package br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.tarcio.casadocodigo.config.validacao.UniqueValue;

public class CategoriaRequest {

	@NotBlank
	@Length(max = 50)
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "O valor do campo {0} já está em uso.")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
}

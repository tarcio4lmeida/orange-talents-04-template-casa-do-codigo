package br.com.zupacademy.tarcio.casadocodigo.cadastro_pais;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.tarcio.casadocodigo.config.validacao.UniqueValue;

public class PaisRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O resgistro de {2} já está em uso")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
	
}

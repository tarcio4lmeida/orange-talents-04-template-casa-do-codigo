package br.com.zupacademy.tarcio.casadocodigo.cadastro_estado;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_pais.Pais;
import br.com.zupacademy.tarcio.casadocodigo.config.validacao.ExistsId;

public class EstadoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Length(max = 50)
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "O resgistro de {2} informado não existe!")
	private Long idPais;
	
	public String getNome() {
		return nome;
	}
	
	public Long getIdPais() {
		return idPais;
	}
	
	public Estado toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, this.idPais);
		
		return new Estado(this.nome,pais);
	}

}

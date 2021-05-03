package br.com.zupacademy.tarcio.casadocodigo.cadastro_clientes;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_estado.Estado;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_pais.Pais;
import br.com.zupacademy.tarcio.casadocodigo.config.validacao.CpfCnpj;
import br.com.zupacademy.tarcio.casadocodigo.config.validacao.ExistsId;
import br.com.zupacademy.tarcio.casadocodigo.config.validacao.UniqueValue;

public class ClienteRequest  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "O resgistro de {2} já está em uso")
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpfCnpj", message = "O resgistro de {2} já está em uso")
	@CpfCnpj(domainClass = Cliente.class, fieldName = "cpfCnpj", message = "CPF/CNPJ inválido")
	@NotBlank
	private String cpfCnpj;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "O resgistro de {2} informado não existe!")
	private Long paisId;
	
	private Long estadoId;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	@Deprecated
	public ClienteRequest() {
	}
	
	public Cliente toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, this.paisId);
		
			Cliente cliente = new Cliente(
						this.email,
						this.nome,
						this.sobrenome,
						this.cpfCnpj,
						this.endereco,
						this.complemento,
						this.cidade,
						pais,
						this.telefone,
						this.cep);
	
		if (this.estadoId != null) {
			Estado estado = manager.find(Estado.class, this.estadoId);
			cliente.setEstado(estado);
		}
		
		return cliente;
		
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

}
 
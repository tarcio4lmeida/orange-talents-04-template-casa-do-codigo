package br.com.zupacademy.tarcio.casadocodigo.cadastro_clientes;

import java.io.Serializable;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_estado.DetalhePais;

public class ClienteResponseComEstado  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String email;
	
	private String nome;
	
	private String sobrenome;
	
	private String cpfCnpj;
	
	private String endereco;
	
	private String complemento;
	
	private String cidade;
	
	private DetalhePais pais;
	
	private DetalheEstado estado;
	
	private String telefone;
	
	private String cep;

	@Deprecated
	public ClienteResponseComEstado() {
	}
	
	public ClienteResponseComEstado(Cliente cliente) {
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.pais = new DetalhePais(cliente.getPais());
		this.estado = new DetalheEstado(cliente.getEstado());
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
	}

	public Long getId() {
		return id;
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

	public DetalhePais getPais() {
		return pais;
	}

	public DetalheEstado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
}

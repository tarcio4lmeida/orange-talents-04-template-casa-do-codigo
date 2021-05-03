package br.com.zupacademy.tarcio.casadocodigo.cadastro_clientes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_estado.Estado;
import br.com.zupacademy.tarcio.casadocodigo.cadastro_pais.Pais;

@Entity
@Table(name ="tb_cliente")
public class Cliente  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String sobrenome;
	
	@Column(nullable = false, unique=true)
	private String cpfCnpj;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String complemento;
	
	@Column(nullable = false)
	private String cidade;
	
	@ManyToOne
	private Pais pais;
	
	@ManyToOne
	private Estado estado;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String cep;

	@Deprecated
	public Cliente() {
	}
	
	public Cliente(String email, String nome, String sobrenome, String cpfCnpj, String endereco, String complemento,
			String cidade, Pais pais, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfCnpj = cpfCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
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

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
}

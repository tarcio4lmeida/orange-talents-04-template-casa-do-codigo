package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_autor")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 30)
	private String nome;
	
	@Column(unique = true, nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false)
	private Instant dataCadastro = Instant.now();
	
	@Column(nullable = false, length = 400)
	private String descricao;
	
	@Deprecated
	public Autor() {
	}
	
	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
	public Instant getDataCadastro() {
		return dataCadastro;
	}
	
	public String getDescricao() {
		return descricao;
	}

}

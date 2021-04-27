package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.controller.form.AutorForm;

@Entity
@Table(name = "tb_autor")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 30)
	private String nome;
	
	@Column(unique=true, length = 30)
	private String email;
	
	@Column(nullable = false)
	private Instant dataCadastro;
	
	@Column(nullable = false, length = 400)
	private String descricao;

	public Autor() {
	}
	
	public Autor(AutorForm dto) {
		this.nome = dto.getNome();
		this.email = dto.getEmail();
		this.dataCadastro = Instant.now();
		this.descricao = dto.getDescricao();
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

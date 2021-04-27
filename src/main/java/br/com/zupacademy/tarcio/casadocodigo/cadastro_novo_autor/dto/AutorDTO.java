package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.entity.Autor;

public class AutorDTO {
	
	private Long id;
	private String nome;
	private String email;
	
	@JsonFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss.SSSXXX", timezone = "America/Sao_Paulo")
	private Instant dataCadastro;
	
	private String descricao;
	
	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataCadastro = autor.getDataCadastro();
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
	public Long getId() {
		return id;
	}
	
}

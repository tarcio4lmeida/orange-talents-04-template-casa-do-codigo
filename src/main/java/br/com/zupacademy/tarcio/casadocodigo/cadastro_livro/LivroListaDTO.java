package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

public class LivroListaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;

	@Deprecated
	public LivroListaDTO() {
	}

	public LivroListaDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	@SuppressWarnings("unchecked")
	public static List<LivroListaDTO> toDTO(EntityManager manager) {
		List<Livro> list = manager.createQuery("Select t from " + Livro.class.getSimpleName() + " t").getResultList();
		return list.stream().map(x-> new LivroListaDTO(x)).collect(Collectors.toList());
	}
}

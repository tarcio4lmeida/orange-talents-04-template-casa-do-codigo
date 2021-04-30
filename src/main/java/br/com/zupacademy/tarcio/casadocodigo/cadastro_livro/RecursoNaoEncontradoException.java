package br.com.zupacademy.tarcio.casadocodigo.cadastro_livro;

public class RecursoNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoException(String msg) {
		super(msg);
	}
}

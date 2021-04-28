package br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeCategoriaComNomeDuplicadoValidator implements Validator{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// Qual o parametro devemos colocar a validacao
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		CategoriaRequest request = (CategoriaRequest) target;
		Optional<Categoria> obj = repository.findByNome(request.getNome());
		if (obj.isPresent()) {
			errors.rejectValue("Nome", null, "Nome da categoria já cadastrado");
		}
	}

}

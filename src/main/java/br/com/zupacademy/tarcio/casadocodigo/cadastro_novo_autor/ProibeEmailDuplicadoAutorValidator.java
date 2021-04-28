package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

	@Autowired
	private AutorRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// Qual o parametro devemos colocar a validacao
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		AutorRequest request = (AutorRequest) target;
		Optional<Autor> obj = repository.findByEmail(request.getEmail());
		if (obj.isPresent()) {
			errors.rejectValue("email", null, "Email já cadastrado");
		}
	}

}

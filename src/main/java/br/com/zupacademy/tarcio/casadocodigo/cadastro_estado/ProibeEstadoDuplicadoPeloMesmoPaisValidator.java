package br.com.zupacademy.tarcio.casadocodigo.cadastro_estado;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEstadoDuplicadoPeloMesmoPaisValidator implements Validator{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// Qual o parametro devemos colocar a validacao
		return EstadoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		EstadoRequest request = (EstadoRequest) target;
		Estado estado = null;
		try {
			estado = (Estado) manager
					.createQuery("Select e " + "from " + Estado.class.getSimpleName() + " e "
							+ " where e.pais.id = :idPais and e.nome = :nome", Estado.class)
					.setParameter("idPais", request.getIdPais()).setParameter("nome", request.getNome())
					.getSingleResult();
		} catch (NoResultException nre) {
			// vou ignorar pq minha lógica está ok.
		}
		if (estado != null) {
			errors.rejectValue("nome", null, "nome já cadastrado para o país "+ estado.getPais().getNome());
		}
	}

}
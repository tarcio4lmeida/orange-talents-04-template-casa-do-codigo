package br.com.zupacademy.tarcio.casadocodigo.cadastro_clientes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_estado.Estado;

/*
 * Classe para impedir que um país que possua estado nao ser cadastrado
 * sem informar o estado
*/
@Component
public class PaisComEstadoValidator implements Validator{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// Qual o parametro devemos colocar a validacao
		return ClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		ClienteRequest request = (ClienteRequest) target;
		List<Estado> listEstado = null;
		
		if (request.getEstadoId() != null) {
			return;
		}
		try {
			listEstado = manager
					.createQuery("Select e " + "from " + Estado.class.getSimpleName() + " e "
							+ " where e.pais.id = :idPais", Estado.class)
					.setParameter("idPais", request.getPaisId())
					.getResultList();
		} catch (NoResultException nre) {
			// vou ignorar pq minha lógica está ok.
		}
		if (!listEstado.isEmpty()) {
			errors.rejectValue("paisId", null, "O país selecionado possui estado, logo, um estado precisa ser selecionado!");
		}
	}

}
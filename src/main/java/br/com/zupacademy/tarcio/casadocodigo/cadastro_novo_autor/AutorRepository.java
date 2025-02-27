package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);
	Optional<Autor> findById(Long id);
}

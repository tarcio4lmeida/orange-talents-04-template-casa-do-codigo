package br.com.zupacademy.tarcio.casadocodigo.cadastro_categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Optional<Categoria> findById(Long id);
	Optional<Categoria> findByNome(String nome);
}

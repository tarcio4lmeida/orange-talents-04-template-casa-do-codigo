package br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.tarcio.casadocodigo.cadastro_novo_autor.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}

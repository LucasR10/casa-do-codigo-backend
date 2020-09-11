package br.com.casacodigo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casacodigo.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

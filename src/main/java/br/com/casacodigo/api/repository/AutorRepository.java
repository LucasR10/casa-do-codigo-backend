package br.com.casacodigo.api.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casacodigo.api.model.Autor;

/**
 * 
 * @author Lucas Carvalho
 * @since 10/09/200
 * 
 */

@Repository
public interface AutorRepository extends JpaRepository<Autor, BigInteger> {

}

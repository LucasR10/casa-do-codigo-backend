package br.com.casacodigo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casacodigo.api.model.Categoria;
import br.com.casacodigo.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}

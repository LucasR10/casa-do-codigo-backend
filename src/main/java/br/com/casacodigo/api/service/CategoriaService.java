package br.com.casacodigo.api.service;

import java.util.List;
import java.util.Optional;

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
		Optional<Categoria> categoriaBanco = categoriaRepository.findByNome(categoria.getNome());
		if (categoriaBanco.isEmpty()) {
			return categoriaRepository.save(categoria);
		}
		return null;
	}

	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	public boolean delete(Long id) {

		Optional<Categoria> categoriaBanco = categoriaRepository.findById(id);

		if (categoriaBanco.isPresent()) {
			categoriaRepository.delete(categoriaBanco.get());
			return true;
		}

		return false;
	}

	public Optional<Categoria> findByNome(String nome) {
		return categoriaRepository.findByNome(nome);
	}

	public Categoria atualiza(Categoria categoria) {
		Optional<Categoria> categoriaBanco = categoriaRepository.findById(categoria.getId());

		if (categoriaBanco.isPresent()) {
			Categoria novaCategoria = categoriaBanco.get();
			novaCategoria.setNome(categoria.getNome());
			return categoriaRepository.save(novaCategoria);
		}

		return null;
	}

}

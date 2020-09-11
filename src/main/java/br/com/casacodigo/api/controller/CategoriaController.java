package br.com.casacodigo.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodigo.api.model.Categoria;
import br.com.casacodigo.api.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<List<Categoria>> getCategoria() {

		List<Categoria> categorias = categoriaService.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Categoria> getById(@PathVariable("id") Long id) {

		Optional<Categoria> categoria = categoriaService.findById(id);

		if (categoria.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(categoria.get());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria) {

		Categoria categoriaSave = categoriaService.save(categoria);

		if (categoriaSave != null) {
			return ResponseEntity.status(HttpStatus.OK).body(categoriaSave);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {

		Categoria categoriaAtualizada = categoriaService.atualiza(categoria);

		if (categoriaAtualizada != null) {
			return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

	}

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<Categoria> delete(@PathVariable("id") Long id) {

		if (categoriaService.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
}

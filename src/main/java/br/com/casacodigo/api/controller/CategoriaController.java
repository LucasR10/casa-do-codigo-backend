package br.com.casacodigo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping
	private List<Categoria> getCategoria() {
		return categoriaService.findAll();
	}
	
	@PostMapping
	private Categoria putCategoria(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}
}

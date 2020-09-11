package br.com.casacodigo.api.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodigo.api.model.Autor;
import br.com.casacodigo.api.service.AutorService;
import io.swagger.annotations.Api;

/**
 * 
 * @author Lucas Carvalho
 * @since 10/09/200
 **/

@RestController
@RequestMapping("/autor")
@Api(value = "Adicionar Autor")
public class AutorController {

    @Autowired
    private AutorService service;
    
    @PostMapping
    public ResponseEntity<Autor> addiconar(@Valid @RequestBody Autor autor) {
	return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarOuAtualizar(autor).get());
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable BigInteger codigo) {
	service.excluir(codigo);
    }
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Autor>> buscar(){
	return ResponseEntity.ok( service.listar() );
    }
    
    @PutMapping
    public ResponseEntity<Autor> atualizar(@Valid @RequestBody Autor autor) {
	Autor autorNew = service.buscarPorId( autor.getCodigo() ).get();
	BeanUtils.copyProperties(autor, autorNew, "id"); 
	return ResponseEntity.status(HttpStatus.OK).body(service.salvarOuAtualizar( autorNew ).get());
    }
    
    
}

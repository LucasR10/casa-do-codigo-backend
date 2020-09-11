package br.com.casacodigo.api.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casacodigo.api.model.Autor;
import br.com.casacodigo.api.repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorService() {
    }

    public Optional<Autor> salvarOuAtualizar(Autor autor) {
	autor.setDataCadastro( Calendar.getInstance() );
	return Optional.of(autorRepository.save(autor));
    }

    public List<Autor> listar() {
	return autorRepository.findAll();
    }

    public void excluir(BigInteger id) {
	autorRepository.deleteById(id);
    }

    public Optional<Autor> buscarPorId(BigInteger id) {
	return autorRepository.findById(id);
    }
}

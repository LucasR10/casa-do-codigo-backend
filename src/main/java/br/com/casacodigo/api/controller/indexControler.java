package br.com.casacodigo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author Lucas Carvalho
 * @since 10/09/200
 * 
 */

@RestController
@RequestMapping("/")
public class indexControler {

    
    @GetMapping
    public String  index(){
	return "configuration ok";
    }
}

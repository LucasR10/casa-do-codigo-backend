package br.com.casacodigo.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void  index(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	String  path =  req.getContextPath()+"/swagger-ui.html";
	resp.sendRedirect(path);
    }
}

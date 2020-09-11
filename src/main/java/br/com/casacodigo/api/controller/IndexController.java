package br.com.casacodigo.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author Lucas Carvalho
 * @since 10/09/200
 * 
 */

@RestController
@RequestMapping("/")
@Api(value = "index")
public class IndexController {

    
    
    @GetMapping  
    @ApiOperation(httpMethod = "GET", value = "Redireciona para swagger-ui.html ")
    public void   index(HttpServletRequest req, HttpServletResponse resp){
	try {
	    resp.sendRedirect(req.getContextPath() +"/swagger-ui.html");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}

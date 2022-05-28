package com.myfreetime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class InicioController {
	
    @GetMapping("/")
    public String mostrarIndex() {
        return "index";
    }
    
    @GetMapping("/login")
    public String mostrarLoginUsuario() {
    	return "login";
    }
}
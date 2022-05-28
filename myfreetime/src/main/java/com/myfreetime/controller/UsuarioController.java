package com.myfreetime.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.myfreetime.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;

import com.myfreetime.service.UsuarioRegistroService;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioController {
	
    @Autowired
    private UsuarioRegistroService usuarioService;
    
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO nuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }
    
    @GetMapping("/registro-usuario")
    public String mostrarRegistroUsuario() {
        return "registro-usuario";
    }
       
    @PostMapping("/registro-usuario")
    public String registrarCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioService.guardar(registroDTO);
        return "redirect:/registro-usuario?exito";
    }
}
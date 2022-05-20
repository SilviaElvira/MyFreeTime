package com.myfreetime.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.myfreetime.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.myfreetime.service.*;
import org.springframework.stereotype.Controller;

@Controller
public class RegistroUsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@ModelAttribute("usuario")
	public UsuarioRegistroDTO nuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarRegistroUsuario() {
		return "registro-usuario";
	}

	@PostMapping
	public String registrarCuentaUsuario(@ModelAttribute("usuario") final UsuarioRegistroDTO registroDTO) {
		usuarioService.guardar(registroDTO);
		return "redirect:/registro-usuarios?exito";
	}
}
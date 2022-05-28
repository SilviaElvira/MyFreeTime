package com.myfreetime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myfreetime.dto.EmpresaRegistroDTO;
import com.myfreetime.service.EmpresaRegistroService;

@Controller
public class EmpresaController {

	@Autowired
	private EmpresaRegistroService empresaService;
	
	@ModelAttribute("empresa")
	public EmpresaRegistroDTO nuevaEmpresaRegistroDTO() {
		return new EmpresaRegistroDTO();
	}
	
	@GetMapping("/registro-empresa")
    public String mostrarRegistroEmpresa() {
        return "registro-empresa";
    }
	
	@PostMapping("/registro-empresa")
    public String registrarCuentaEmpresa(@ModelAttribute("empresa") final EmpresaRegistroDTO registroDTO) {
		this.empresaService.guardar(registroDTO);
		return "redirect:/registro-empresa?exito";
	}
}
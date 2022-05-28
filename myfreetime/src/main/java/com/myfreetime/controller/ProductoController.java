package com.myfreetime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myfreetime.dto.ProductoRegistroDTO;
import com.myfreetime.repository.ProductoRepository;
import com.myfreetime.service.ProductoRegistroService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoRegistroService productoService;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@ModelAttribute("producto")
	public ProductoRegistroDTO nuevoProductoRegistroDTO() {
		return new ProductoRegistroDTO();
	}
	
	@GetMapping("/actividades")
    public String mostrarActividades(Model model) {
		model.addAttribute("producto", productoRepository.findAll());
        return "actividades";
    }
	
	@GetMapping("/registro-actividades")
    public String mostrarProductos() {
		return "registro-actividades";
    }
	
	@PostMapping("/registro-actividades")
    public String registrarCuentaEmpresa(@ModelAttribute ("producto") ProductoRegistroDTO registroDTO) {
		productoService.guardar(registroDTO);
		return "redirect:/registro-actividades?exito";
	}
	
	
}

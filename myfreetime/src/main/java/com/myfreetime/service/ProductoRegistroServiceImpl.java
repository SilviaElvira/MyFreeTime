package com.myfreetime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfreetime.dto.ProductoRegistroDTO;
import com.myfreetime.model.Producto;
import com.myfreetime.repository.ProductoRepository;

@Service
public class ProductoRegistroServiceImpl implements ProductoRegistroService{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto guardar(ProductoRegistroDTO registroDTO) {
		Producto producto = new Producto(
				registroDTO.getNombre(), registroDTO.getActividad(), registroDTO.getDescripcion(), registroDTO.getPrecio(),
				registroDTO.getProvincia(), registroDTO.getLocalidad(), registroDTO.getImparticion(), registroDTO.getTelefono(), 
				registroDTO.getEmail()
				);
				return productoRepository.save(producto);
	}
	
	@Override
	public List<Producto> mostrar(ProductoRegistroDTO registroDTO) {
		return productoRepository.findAll();
	}
	
}

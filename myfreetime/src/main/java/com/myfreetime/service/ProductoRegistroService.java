package com.myfreetime.service;

import java.util.List;

import com.myfreetime.dto.ProductoRegistroDTO;
import com.myfreetime.model.Producto;

public interface ProductoRegistroService {

	Producto guardar(ProductoRegistroDTO registroDTO);
	
	List<Producto> mostrar(ProductoRegistroDTO registroDTO);
}

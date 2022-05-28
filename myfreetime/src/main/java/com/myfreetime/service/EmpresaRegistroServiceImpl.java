package com.myfreetime.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfreetime.dto.EmpresaRegistroDTO;
import com.myfreetime.model.Empresa;
import com.myfreetime.model.Rol;
import com.myfreetime.repository.EmpresaRepository;

@Service
public class EmpresaRegistroServiceImpl implements EmpresaRegistroService{

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Empresa guardar(EmpresaRegistroDTO registroDTO) {
		Empresa empresa = new Empresa(registroDTO.getNombre(), registroDTO.getEmail(),
				registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_ADMIN")));
		return empresaRepository.save(empresa);
	}
}

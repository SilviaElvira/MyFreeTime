package com.myfreetime.service;

import java.util.Collection;
import java.util.Arrays;
import com.myfreetime.model.Rol;
import com.myfreetime.model.Usuario;
import com.myfreetime.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.myfreetime.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRegsitroServiceImpl implements UsuarioRegistroService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellidos(), registroDTO.getEmail(),
				registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepository.save(usuario);
	}
}
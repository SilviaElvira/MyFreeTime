package com.myfreetime.service;

import com.myfreetime.model.Usuario;
import com.myfreetime.dto.UsuarioRegistroDTO;

public interface UsuarioRegistroService
{
	Usuario guardar(UsuarioRegistroDTO registroDTO);
}
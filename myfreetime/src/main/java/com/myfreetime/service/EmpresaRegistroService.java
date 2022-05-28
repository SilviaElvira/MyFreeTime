package com.myfreetime.service;

import com.myfreetime.model.Empresa;
import com.myfreetime.dto.EmpresaRegistroDTO;

public interface EmpresaRegistroService {

	Empresa guardar(EmpresaRegistroDTO registroDTO);
}

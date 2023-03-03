package com.mantenimiento.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantenimiento.entities.TipoDocumento;
import com.mantenimiento.exceptions.ErrorException;
import com.mantenimiento.exceptions.NotFountException;
import com.mantenimiento.repositories.TipoDocumentoRepository;
import com.mantenimiento.services.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;

	public static final ModelMapper modelMaper = new ModelMapper();

	public List<TipoDocumento> getTipoDocumento() throws ErrorException {
		List<TipoDocumento> tipoDocumento = null;
		try {
			tipoDocumento = tipoDocumentoRepository.getTipoDocumento();
		} catch (Exception e) {
			new NotFountException("SNOT-404-1", "TIPO_CONTRIBUYENTE_NOT_FOUND");
		}

		return tipoDocumento;
	}

}

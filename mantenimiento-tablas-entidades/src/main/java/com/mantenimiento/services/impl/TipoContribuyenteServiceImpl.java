package com.mantenimiento.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantenimiento.entities.TipoContribuyente;
import com.mantenimiento.exceptions.ErrorException;
import com.mantenimiento.exceptions.NotFountException;
import com.mantenimiento.repositories.TipoContribuyenteRepository;
import com.mantenimiento.services.TipoContribuyenteService;

@Service
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService {

	@Autowired
	TipoContribuyenteRepository tipoContribuyenteRepository;

	public static final ModelMapper modelMaper = new ModelMapper();

	public List<TipoContribuyente> getTipoContribuyente() throws ErrorException {
		List<TipoContribuyente> tipoContribuyente = null;
		try {
			tipoContribuyente = tipoContribuyenteRepository.getTipoContribuyente();
		} catch (Exception e) {
			new NotFountException("SNOT-404-1", "TIPO_CONTRIBUYENTE_NOT_FOUND");
			System.out.println("Error:" + e);
		}

		return tipoContribuyente;
	}

}

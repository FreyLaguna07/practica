package com.mantenimiento.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantenimiento.dtos.InsertEntidadDto;
import com.mantenimiento.entities.Entidad;
import com.mantenimiento.exceptions.ErrorException;
import com.mantenimiento.exceptions.NotFountException;
import com.mantenimiento.repositories.EntidadRepository;
import com.mantenimiento.services.EntidadService;

@Service
public class EntidadServiceImpl implements EntidadService {

	@Autowired
	EntidadRepository entidadRepository;

	public static final ModelMapper modelMaper = new ModelMapper();

	public List<Entidad> getEntidad() throws ErrorException {
		List<Entidad> entidad = null;
		try {
			entidad = entidadRepository.getEntidad();
		} catch (Exception e) {
			new NotFountException("SNOT-404-1", "TIPO_CONTRIBUYENTE_NOT_FOUND");
			System.out.println("Exception"+e);
		}

		return entidad;
	}

	public Integer insertEntidad(InsertEntidadDto entidad) throws ErrorException {
		Integer resp = 0;
		try {
			resp = entidadRepository.insertEntidad(entidad.getId_tipo_documento(), entidad.getNro_documento(),
					entidad.getRazon_social(), entidad.getNombre_comercial(), entidad.getId_tipo_contribuyente(),
					entidad.getDireccion(), entidad.getTelefono());
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return resp;
	}
	public Integer updateEntidad(InsertEntidadDto entidad) throws ErrorException {
		Integer resp = 0;
		try {
			resp = entidadRepository.updateEntidad(entidad.getId(),entidad.getId_tipo_documento(), entidad.getNro_documento(),
					entidad.getRazon_social(), entidad.getNombre_comercial(), entidad.getId_tipo_contribuyente(),
					entidad.getDireccion(), entidad.getTelefono());
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return resp;
	}
	
	public Integer deleteEntidad(int id) throws ErrorException {
		Integer resp = 0;
		try {
			resp = entidadRepository.deleteEntidad(id);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return resp;
	}
	
	
}

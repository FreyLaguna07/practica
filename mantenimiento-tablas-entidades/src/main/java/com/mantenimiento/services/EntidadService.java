package com.mantenimiento.services;

import java.util.List;

import com.mantenimiento.dtos.InsertEntidadDto;
import com.mantenimiento.entities.Entidad;
import com.mantenimiento.exceptions.ErrorException;

public interface EntidadService {

	public List<Entidad> getEntidad() throws ErrorException;

	public Integer insertEntidad(InsertEntidadDto entidad) throws ErrorException;

	public Integer updateEntidad(InsertEntidadDto entidad) throws ErrorException;

	public Integer deleteEntidad(int id) throws ErrorException;
}

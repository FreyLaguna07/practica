package com.mantenimiento.services;

import java.util.List;

import com.mantenimiento.entities.TipoContribuyente;
import com.mantenimiento.exceptions.ErrorException;

public interface TipoContribuyenteService {

	public List<TipoContribuyente> getTipoContribuyente() throws ErrorException;
}

package com.mantenimiento.services;

import java.util.List;

import com.mantenimiento.entities.TipoDocumento;
import com.mantenimiento.exceptions.ErrorException;

public interface TipoDocumentoService {

	public List<TipoDocumento> getTipoDocumento() throws ErrorException;
}

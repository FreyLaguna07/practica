package com.mantenimiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantenimiento.entities.TipoDocumento;
import com.mantenimiento.exceptions.ErrorException;
import com.mantenimiento.responses.EntidadResponse;
import com.mantenimiento.services.TipoDocumentoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/tipo-documento" + "v1")
public class TipoDocumentoController {

	@Autowired
	TipoDocumentoService tipoDocumentoService;

	@GetMapping("/get-tipo-docuento")
	public EntidadResponse<TipoDocumento> getTipoDocumento() throws ErrorException {
		return new EntidadResponse("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				tipoDocumentoService.getTipoDocumento());
	}

}

package com.mantenimiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantenimiento.entities.TipoContribuyente;
import com.mantenimiento.exceptions.ErrorException;
import com.mantenimiento.responses.EntidadResponse;
import com.mantenimiento.services.TipoContribuyenteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/tipo-contribuyente" + "v1")
public class TipoContribuyenteController {

	@Autowired
	TipoContribuyenteService tipoContribuyenteService;

	@GetMapping("/get-tipo-contribuyente")
	public EntidadResponse<TipoContribuyente> getTipoContribuyente() throws ErrorException {
		return new EntidadResponse("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				tipoContribuyenteService.getTipoContribuyente());
	}

}

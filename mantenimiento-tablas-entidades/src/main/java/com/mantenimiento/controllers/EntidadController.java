package com.mantenimiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantenimiento.dtos.InsertEntidadDto;
import com.mantenimiento.entities.Entidad;
import com.mantenimiento.exceptions.ErrorException;
import com.mantenimiento.responses.EntidadResponse;
import com.mantenimiento.services.EntidadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/entidad" + "v1")
public class EntidadController {

	@Autowired
	EntidadService entidadService;

	@GetMapping("/get-entidad")
	public EntidadResponse<Entidad> getEntidad() throws ErrorException {
		return new EntidadResponse("SUCCES", String.valueOf(HttpStatus.OK), "OK", entidadService.getEntidad());
	}

	@PostMapping("/insert-entidad")
	public EntidadResponse<Integer> insertEntidad(InsertEntidadDto insertEntidadDto) throws ErrorException {
		return new EntidadResponse("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				entidadService.insertEntidad(insertEntidadDto));
	}

	@PutMapping("/update-entidad")
	public EntidadResponse<Integer> updateEntidad(InsertEntidadDto insertEntidadDto) throws ErrorException {
		return new EntidadResponse("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				entidadService.updateEntidad(insertEntidadDto));
	}

	@DeleteMapping("/delete-entidad")
	public EntidadResponse<Integer> deleteEntidad(@RequestParam("idEntidad") Integer idEntidad) throws ErrorException {
		return new EntidadResponse("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				entidadService.deleteEntidad(idEntidad));
	}

}

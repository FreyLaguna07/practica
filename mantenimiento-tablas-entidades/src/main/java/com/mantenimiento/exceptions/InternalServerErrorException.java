package com.mantenimiento.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.mantenimiento.dtos.ErrorDto;

public class InternalServerErrorException extends ErrorException{

	private static final long serialVersionUID = 1L;
	public InternalServerErrorException(String codigo, String mensaje) {
		super(codigo,HttpStatus.INTERNAL_SERVER_ERROR.value(), mensaje);
	}
	public InternalServerErrorException(String codigo, String mensaje, ErrorDto data) {
		super(codigo,HttpStatus.INTERNAL_SERVER_ERROR.value(), mensaje, Arrays.asList(data));
	}
}

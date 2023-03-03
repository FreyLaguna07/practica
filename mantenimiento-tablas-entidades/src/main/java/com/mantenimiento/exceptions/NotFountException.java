package com.mantenimiento.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.mantenimiento.dtos.ErrorDto;

public class NotFountException extends ErrorException{
	
	private static final long serialVersionUID = 1L;

	public NotFountException(String codigo, String mensaje) {
		super(codigo,HttpStatus.NOT_FOUND.value(), mensaje);
	}
	public NotFountException(String codigo, String mensaje, ErrorDto data) {
		super(codigo,HttpStatus.NOT_FOUND.value(), mensaje, Arrays.asList(data));
	}

}

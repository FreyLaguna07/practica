package com.mantenimiento.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.mantenimiento.dtos.ErrorDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String codigo;
	private final int respCodigo;
	private final List<ErrorDto> errorList = new ArrayList<>();
	
	public ErrorException(String codigo, int respCodigo, String mensaje) {
		super(mensaje);
		this.codigo = codigo;
		this.respCodigo = respCodigo;
	}
	public ErrorException(String codigo, int respCodigo, String mensaje, List<ErrorDto> errorList) {
		super(mensaje);
		this.codigo = codigo;
		this.respCodigo = respCodigo;
		this.errorList.addAll(errorList);
	}
}

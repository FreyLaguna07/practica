package com.mantenimiento.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String valor;
	
	public ErrorDto (String nombre, String valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
}

package com.mantenimiento.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertEntidadDto {
	private int id;
	private int id_tipo_documento;
	private String nro_documento;
	private String razon_social;
	private String nombre_comercial;
	private int id_tipo_contribuyente;
	private String direccion;
	private String telefono;
	
}

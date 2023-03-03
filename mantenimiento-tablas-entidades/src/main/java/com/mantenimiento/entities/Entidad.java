package com.mantenimiento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_entidad")
public class Entidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_entidad", unique = true, nullable = false)
	private int id_entidad;

	@Column(name = "nro_documento", nullable = true, unique = false)
	private String nro_documento;

	@Column(name = "razon_social", nullable = false)
	private String razon_social;

	@Column(name = "nombre_comercial", columnDefinition = "tinyint(null) default null")
	private String nombre_comercial;

	@Column(name = "direccion", columnDefinition = "tinyint(null) default null")
	private String direccion;

	@Column(name = "telefono", columnDefinition = "tinyint(null) default null")
	private String telefono;

	@Column(name = "estado", nullable = true, columnDefinition = "tinyint(null) default null")
	private int estado;

	@OneToOne
	@JoinColumn(name = "id_tipo_contribuyente")
	private TipoContribuyente tipoContribuyente;

	@OneToOne
	@JoinColumn(name = "id_tipo_documento")
	private TipoDocumento tipoDocumento;

}

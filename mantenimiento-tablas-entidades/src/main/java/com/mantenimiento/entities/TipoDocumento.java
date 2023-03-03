package com.mantenimiento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_tipo_documento")
public class TipoDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_tipo_documento", unique = true, nullable = false)
	@Fetch(FetchMode.JOIN)
	private int id_tipo_documento;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "descripcion", columnDefinition = "tinyint(null) default null")
	private String descripcion;

	@Column(name = "estado", nullable = false, columnDefinition = "tinyint(1) default 1")
	private int estado;
}

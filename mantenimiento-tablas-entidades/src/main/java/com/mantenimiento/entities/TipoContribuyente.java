package com.mantenimiento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_tipo_contribuyente", unique = true, nullable = false)
	private int id_tipo_contribuyente;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private int estado;
}

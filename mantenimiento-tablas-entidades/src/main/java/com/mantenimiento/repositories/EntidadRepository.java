package com.mantenimiento.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mantenimiento.entities.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {

	@Query(value = "SELECT en.* FROM tb_entidad en \r\n"
			+ "INNER JOIN tb_tipo_contribuyente tc ON en.id_tipo_contribuyente =tc.id_tipo_contribuyente\r\n"
			+ "inner join tb_tipo_documento td on en.id_tipo_documento = td.id_tipo_documento WHERE en.estado = 1", nativeQuery = true)
	public List<Entidad> getEntidad();

	@Modifying
	@Query(value = "INSERT INTO tb_entidad (id_tipo_documento,nro_documento,razon_social,nombre_comercial,id_tipo_contribuyente,direccion,telefono) SELECT :id_tipo_documento, :nro_documento, :razon_social, :nombre_comercial, :id_tipo_contribuyente, :direccion, :telefono ", nativeQuery = true, countQuery = "select 0")
	@Transactional
	public Integer insertEntidad(@Param("id_tipo_documento") Integer id_tipo_documento,
			@Param("nro_documento") String nro_documento, @Param("razon_social") String razon_social,
			@Param("nombre_comercial") String nombre_comercial,
			@Param("id_tipo_contribuyente") Integer id_tipo_contribuyente, @Param("direccion") String direccion,
			@Param("telefono") String telefono);

	@Modifying
	@Query(value = "UPDATE tb_entidad SET id_tipo_documento=:id_tipo_documento,nro_documento=:nro_documento,razon_social=:razon_social,nombre_comercial=:nombre_comercial,id_tipo_contribuyente=:id_tipo_contribuyente,direccion=:direccion,telefono=:telefono WHERE id_entidad=:id", nativeQuery = true, countQuery = "select 0")
	@Transactional
	public Integer updateEntidad(@Param("id") Integer id, @Param("id_tipo_documento") Integer id_tipo_documento,
			@Param("nro_documento") String nro_documento, @Param("razon_social") String razon_social,
			@Param("nombre_comercial") String nombre_comercial,
			@Param("id_tipo_contribuyente") Integer id_tipo_contribuyente, @Param("direccion") String direccion,
			@Param("telefono") String telefono);

	@Modifying
	@Query(value = "UPDATE tb_entidad SET estado=0 WHERE id_entidad=:id", nativeQuery = true, countQuery = "select 0")
	@Transactional
	public Integer deleteEntidad(@Param("id") Integer id);

}

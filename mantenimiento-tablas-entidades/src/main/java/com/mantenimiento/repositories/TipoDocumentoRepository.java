package com.mantenimiento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mantenimiento.entities.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {

	@Query(value = "SELECT * FROM tb_tipo_documento WHERE estado = 1", nativeQuery = true)
	public List<TipoDocumento> getTipoDocumento();

}

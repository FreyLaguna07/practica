package com.mantenimiento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mantenimiento.entities.TipoContribuyente;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {

	@Query(value = "SELECT * FROM tb_tipo_contribuyente WHERE estado = 1", nativeQuery = true)
	public List<TipoContribuyente> getTipoContribuyente();

}

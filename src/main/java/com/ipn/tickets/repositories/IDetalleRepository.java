package com.ipn.tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ipn.tickets.model.CDetalle;
import com.ipn.tickets.model.CDetallePK;

public interface IDetalleRepository extends JpaRepository<CDetalle, CDetallePK> {
	@Query(value = "SELECT COALESCE(MAX(a.d_n_consec), 0) "
			+ "FROM d_ticket a WHERE a.pk_i_ticket = :pk_i_ticket AND a.pk_i_anio = :pk_i_anio", nativeQuery = true)
	int findMaxDetalle(@Param("pk_i_ticket") int pk_i_ticket, @Param("pk_i_anio") int pk_i_anio);
}

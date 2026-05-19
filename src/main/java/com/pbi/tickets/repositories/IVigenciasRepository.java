package com.pbi.tickets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pbi.tickets.dto.AdscripcionDTO;
import com.pbi.tickets.model.CVigencia;

public interface IVigenciasRepository extends JpaRepository<CVigencia, Integer> {

	@Query(value = "SELECT v.c_i_adscrip, " + "v.pk_i_vigencia, " + "a.d_v_adscrip AS tDescAdscripcion "
			+ "FROM c_vigencia v " + "INNER JOIN c_adscrip a ON v.c_i_adscrip = a.c_i_adscrip "
			+ "WHERE v.w_v_status = 'A' " + "AND a.w_v_status = 'A' "
			+ "ORDER BY v.pk_i_vigencia DESC", nativeQuery = true)
	List<AdscripcionDTO> findAreas();

	@Query(value = """
			SELECT
			    v.pk_i_vigencia,
			    v.c_i_adscrip,
			    a.d_v_adscrip
			FROM c_vigencia v
			INNER JOIN c_adscrip a
			    ON v.c_i_adscrip = a.c_i_adscrip
			ORDER BY v.pk_i_vigencia DESC;
			""", nativeQuery = true)
	List<AdscripcionDTO> findAdscripArea();

	@Query(value = "SELECT b.d_v_adscrip FROM c_usuario a INNER JOIN c_adscrip b ON a.c_i_adscri = b.c_i_adscrip WHERE a.c_i_usuario = :c_i_placa", nativeQuery = true)
	String findNombreArea(@Param("c_i_placa") Integer c_i_placa);

	@Query(value = "SELECT a.c_i_adscri FROM c_usuario a WHERE c_i_usuario = :c_i_placa", nativeQuery = true)
	Integer findAdscrip(@Param("c_i_placa") Integer c_i_placa);

	@Query(value = "SELECT pk_i_vigencia FROM c_vigencia WHERE c_i_adscrip = :c_i_adscrip", nativeQuery = true)
	Integer findVigencia(@Param("c_i_adscrip") Integer c_i_adscrip);

}

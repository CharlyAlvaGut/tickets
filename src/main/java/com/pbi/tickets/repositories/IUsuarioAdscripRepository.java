package com.pbi.tickets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pbi.tickets.dto.AdscripcionDTO;
import com.pbi.tickets.model.CUsuarioAdscrip;
import com.pbi.tickets.model.CUsuarioAdscripPK;

public interface IUsuarioAdscripRepository extends JpaRepository<CUsuarioAdscrip, CUsuarioAdscripPK> {
	@Query(value = """
			SELECT
			    a.c_i_adscrip,
			    a.pk_i_vigencia,
			    b.d_v_adscrip
			FROM c_vigencia a
			INNER JOIN c_adscrip b
			    ON a.c_i_adscrip = b.c_i_adscrip
			WHERE a.c_i_adscrip NOT IN (
			    SELECT c_i_adscrip
			    FROM d_usuarioadscrip
			    WHERE c_i_usuario = :c_i_usuario
			)
ORDER BY a.pk_i_vigencia DESC;
																""", nativeQuery = true)
	List<AdscripcionDTO> findAreasDisponibles(@Param("c_i_usuario") Integer c_i_usuario);

	@Query(value = """
			SELECT
			    a.c_i_adscrip,
			    a.pk_i_vigencia,
			    b.d_v_adscrip AS tDescAdscripcion
			FROM c_vigencia a
			INNER JOIN c_adscrip b
			    ON a.c_i_adscrip = b.c_i_adscrip
			INNER JOIN d_usuarioadscrip c
			    ON a.c_i_adscrip = c.c_i_adscrip
			WHERE c.c_i_usuario = :c_i_usuario
			ORDER BY a.pk_i_vigencia DESC;
																			""", nativeQuery = true)
	List<AdscripcionDTO> findAreasAsignadas(@Param("c_i_usuario") Integer c_i_usuario);
	
	
	@Query(value = """
			DELETE FROM d_usuarioadscrip WHERE c_i_usuario = :c_i_usuario
																			""", nativeQuery = true)
	void eliminar(@Param("c_i_usuario") Integer c_i_usuario);

	
}

package com.pbi.tickets.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pbi.tickets.dto.UsuarioDTO;
import com.pbi.tickets.model.CUsuario;

public interface IUsuarioRepository extends JpaRepository<CUsuario, Integer> {

	@Query("SELECT u FROM CUsuario u WHERE u.d_v_email = :email")
	CUsuario buscarPorEmail(@Param("email") String email);
	
	@Query("SELECT u.d_v_email FROM CUsuario u WHERE u.c_i_usuario = :idUsuario")
	String findCorreoByIdUsuario(@Param("idUsuario") Integer idUsuario);

	@Query(value = "SELECT d_v_nombre AS tNombre FROM c_usuario WHERE c_i_usuario = :c_i_usuario;", nativeQuery = true)
	String findNombreByUsuario(@Param("c_i_usuario") Integer c_i_usuario);

	@Query(value = "SELECT a.nIdNumEmp AS c_i_usuario, " + "a.tNombre AS d_v_nombre, " + "b.d_v_password, "
			+ "b.pk_i_perfil " + "FROM v_personal a " + "LEFT JOIN c_usuario b ON a.nIdNumEmp = b.c_i_usuario "
			+ "WHERE a.tAdsc BETWEEN 13400 AND 13423 AND b.c_i_usuario IS NULL ORDER BY 2;", nativeQuery = true)
	List<UsuarioDTO> findPersonal();

	@Query(value = """
			SELECT 
				a.c_i_usuario, 
				a.d_v_nombre, 
				a.c_i_adscri AS c_i_adscrip
			FROM c_usuario a
			INNER JOIN c_adscrip b ON a.c_i_adscri = b.c_i_adscrip
			ORDER BY 2;
			""", nativeQuery = true)
	List<UsuarioDTO> findPersonalDTI();

	@Query(value = """
			SELECT 
				a.c_i_usuario, 
				a.d_v_nombre, 
				a.c_i_adscri AS c_i_adscrip,
				b.d_v_adscrip AS c_i_adscrip_1,   
				a.d_v_email AS c_i_adscripNva,  
				b.d_f_fechcap, b.w_v_status 
			FROM c_usuario a 
			INNER JOIN c_adscrip b ON a.c_i_adscri = b.c_i_adscrip
			WHERE CAST(a.d_v_email AS CHAR) LIKE CONCAT('%', :palabra, '%') OR a.d_v_nombre LIKE CONCAT('%', :palabra, '%');
			""", nativeQuery = true)
	List<Object[]> findByWord(@Param("palabra") String palabra);

	@Query(value = "SELECT a.c_i_usuario, a.d_v_nombre, a.c_i_adscri, a.d_v_password, a.pk_i_perfil, a.w_v_status, a.d_v_email FROM c_usuario a WHERE a.c_i_adscri = :c_i_adscrip", nativeQuery = true)
	List<Object[]> findByArea(@Param("c_i_adscrip") String c_i_adscrip);

	/* Consulta para filtrar por Usuario del departamento */
	@Query(value = "SELECT CONCAT(a.nIdNumEmp,' - ',a.tNombre) AS area, "
			+ "SUM(CASE WHEN t.pk_i_estado = 1 THEN 1 ELSE 0 END) AS cantidad_abiertos, "
			+ "SUM(CASE WHEN t.pk_i_estado = 2 THEN 1 ELSE 0 END) AS cantidad_cerrados, "
			+ "COUNT(*) AS cantidad_total " + "FROM v_personal a "
			+ "INNER JOIN m_ticket t ON a.nIdNumEmp = t.c_i_numempasigna " + "WHERE a.tAdsc BETWEEN 13400 AND 13423 "
			+ "AND (:fechaIni IS NULL OR t.d_f_fecha >= :fechaIni) "
			+ "AND (:fechaFin IS NULL OR t.d_f_fecha <= :fechaFin) " + "GROUP BY a.nIdNumEmp, a.tNombre "
			+ "ORDER BY a.tNombre", nativeQuery = true)
	List<Object[]> findCantidadTickets(@Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin);

}

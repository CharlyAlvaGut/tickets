package com.ipn.tickets.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ipn.tickets.dto.CabeceraDTO;
import com.ipn.tickets.dto.HiloDTO;
import com.ipn.tickets.dto.MemorandumDTO;
import com.ipn.tickets.dto.TicketDTO;
import com.ipn.tickets.model.CTicket;
import com.ipn.tickets.model.CTicketPK;

public interface ITicketRepository extends JpaRepository<CTicket, CTicketPK> {
	@Query(value = "SELECT COALESCE(MAX(t.pk_i_ticket), 0) "
			+ "FROM m_ticket t WHERE t.pk_i_anio = :anio", nativeQuery = true)
	int findMaxTicketByAnio(@Param("anio") int anio);

	@Query(value = "SELECT pk_i_asunto FROM m_ticket t WHERE t.pk_i_ticket = :pk_i_ticket AND  t.pk_i_anio = :pk_i_anio", nativeQuery = true)
	int findTipoAsunto(@Param("pk_i_ticket") int pk_i_ticket, @Param("pk_i_anio") int pk_i_anio);

	@Query(value = """
			SELECT COUNT(*) AS total_tickets
			FROM (
					SELECT
							a.pk_i_ticket
					FROM m_ticket a
					INNER JOIN c_estado b ON a.pk_i_estado = b.pk_i_estado
					INNER JOIN c_usuario c ON a.c_i_numempasigna = c.c_i_usuario
					WHERE c.d_v_email = :c_i_usuario
						AND a.pk_i_estado = 1
			) ticket;

													""", nativeQuery = true)
	int findNumeroAsignados(@Param("c_i_usuario") String c_i_usuario);

	@Query(value = """
			SELECT
			    t.pk_i_ticket,
			    t.pk_i_anio,
			    t.c_i_numemp,
			    t.c_i_adscrip,
			    t.c_i_adscripasigna,
			    t.c_i_numempasigna,
			    t.pk_i_fuente,
			    t.d_v_asunto,
			    t.pk_i_folio,
			    t.pk_i_vigencia,
			    d.d_v_nomdocto,
			    d.d_b_documento
			FROM m_ticket t
			LEFT JOIN d_documento d
			       ON d.pk_i_ticket = t.pk_i_ticket
			      AND d.pk_i_anio = t.pk_i_anio
			      AND d.d_n_consec = 1
			WHERE t.pk_i_ticket = :ticketId
			AND t.pk_i_anio = :anio;
													""", nativeQuery = true)
	TicketDTO findTicketById(@Param("ticketId") int pk_i_ticket, @Param("anio") int pk_i_anio);

	@Query(value = """
			 SELECT
					a.pk_i_ticket,
					a.pk_i_anio,
					a.d_f_fecha AS fecha,
					c.d_v_nombre AS solicitante,
					a.d_v_asunto AS asunto,
					d.d_v_nombre AS asignado,
					a.pk_i_estado
			FROM m_ticket a
			INNER JOIN c_estado b ON a.pk_i_estado = b.pk_i_estado
			INNER JOIN c_usuario c ON a.c_i_numemp = c.c_i_usuario
			INNER JOIN c_usuario d ON a.c_i_numempasigna = d.c_i_usuario
			INNER JOIN d_usuarioadscrip ua ON a.c_i_adscripasigna = ua.c_i_adscrip
			WHERE ua.c_i_usuario = :c_i_usuario
			ORDER BY a.d_f_fecha DESC, a.pk_i_ticket DESC;
							""", nativeQuery = true)
	List<TicketDTO> findAllTickets(@Param("c_i_usuario") int c_i_usuario);

	@Query(value = """
			SELECT
				a.pk_i_ticket,
				a.pk_i_anio,
				a.d_f_fecha AS fecha,
				c.d_v_nombre AS solicitante,
				a.d_v_asunto AS asunto,
				d.d_v_nombre AS asignado,
				a.pk_i_estado
			FROM m_ticket a
			INNER JOIN c_usuario c ON a.c_i_numemp = c.c_i_usuario
			INNER JOIN c_usuario d ON a.c_i_numempasigna = d.c_i_usuario
			WHERE a.c_i_numempasigna = :c_i_usuario
			ORDER BY a.d_f_fecha DESC, a.pk_i_ticket DESC;
										""", nativeQuery = true)
	List<TicketDTO> findTicketsByUsuario(@Param("c_i_usuario") int c_i_usuario);

	@Query(value = """
			SELECT
				 a.pk_i_ticket,
				 a.pk_i_anio,
				 a.d_f_fecha AS fecha,
				 p_sol.d_v_nombre AS solicitante,
				 a.d_v_asunto AS asunto
			FROM m_ticket a
			INNER JOIN c_estado b ON (a.pk_i_estado = b.pk_i_estado)
			INNER JOIN c_usuario p_sol ON a.c_i_numemp = p_sol.c_i_usuario
			WHERE a.c_i_numempasigna = :c_i_placa AND a.pk_i_estado = 1
			ORDER BY 1 DESC;
						""", nativeQuery = true)
	List<TicketDTO> findTicketsByUser(@Param("c_i_placa") int c_i_placa);

	@Query(value = """
			SELECT
				a.pk_i_ticket, a.pk_i_anio,
				a.d_f_fecha AS fecha_creacion,
				ad_sol.d_v_adscrip AS adscrip_sol,
				p_sol.d_v_nombre AS solicitante,
				ad_asig.d_v_adscrip AS adscrip_asigna,
				p_asig.d_v_nombre AS asignado,
				b.d_v_estado,
				c.d_i_horas AS horas,
				a.d_v_asunto AS asunto,
				f.d_v_fuente AS fuente,
				a.pk_i_estado,
				p_cap.d_v_nombre AS captura
			FROM m_ticket a
			INNER JOIN c_estado b ON (a.pk_i_estado = b.pk_i_estado)
			INNER JOIN c_vigencia c ON (a.pk_i_vigencia = c.pk_i_vigencia)
			INNER JOIN c_usuario p_sol ON a.c_i_numemp = p_sol.c_i_usuario
			INNER JOIN c_adscrip ad_sol ON a.c_i_adscrip = ad_sol.c_i_adscrip
			INNER JOIN c_usuario p_asig ON a.c_i_numempasigna = p_asig.c_i_usuario
			INNER JOIN c_adscrip ad_asig ON a.c_i_adscripasigna = ad_asig.c_i_adscrip
			INNER JOIN c_fuente f ON (a.pk_i_fuente = f.pk_i_fuente)
			INNER JOIN c_usuario p_cap ON a.c_n_usucap = p_cap.c_i_usuario
			WHERE a.pk_i_ticket = :pk_i_ticket AND a.pk_i_anio = :pk_i_anio
								""", nativeQuery = true)
	CabeceraDTO findCabeceraTicket(@Param("pk_i_ticket") int pk_i_ticket, @Param("pk_i_anio") int pk_i_anio);

	@Query(value = """
			SELECT
				 a.pk_i_ticket,
				 a.pk_i_anio,
				 'CREACION' AS tipo_evento,
				 a.c_i_numemp AS actor,
				 p_sol.d_v_nombre AS nombre_actor,
				 a.d_f_fechcap AS fecha_evento,
				 a.d_v_asunto AS descripcion,
				 doc_asunto.d_v_nomdocto AS documento,
				 doc_asunto.d_b_documento AS archivo_blob,
				 doc_asunto.d_n_consec AS consecutivo_documento,
				 '' AS asignado,
				 ad.d_v_adscrip AS adscripcion,
				 '' AS area_ayuda,
				 a.pk_i_asunto AS pk_i_asunto
			FROM m_ticket a
			LEFT JOIN (
					SELECT pk_i_ticket, pk_i_anio, d_v_nomdocto, d_b_documento, d_n_consec
					FROM d_documento
					WHERE pk_i_tipodoc = 1 -- ASUNTO
						AND d_b_documento IS NOT NULL
			) doc_asunto
					ON a.pk_i_ticket = doc_asunto.pk_i_ticket AND a.pk_i_anio = doc_asunto.pk_i_anio
			LEFT JOIN c_usuario p_sol ON a.c_i_numemp = p_sol.c_i_usuario
			LEFT JOIN c_adscrip ad
			 ON a.c_i_adscrip = ad.c_i_adscrip
			WHERE a.pk_i_ticket = :pk_i_ticket AND a.pk_i_anio = :pk_i_anio

			UNION ALL

			-- Eventos RESPUESTA / TURNADO / NOTA INTERNA desde d_ticket
			SELECT
				 d.pk_i_ticket,
				 d.pk_i_anio,
				 UPPER(e.d_v_respuesta) AS tipo_evento,
				 d.c_n_usucap AS actor,
				 f.d_v_nombre AS nombre_actor,
				 d.d_f_fechcap AS fecha_evento,
				 d.d_v_comentario AS descripcion,
				 doc_resp.d_v_nomdocto AS documento,
				 doc_resp.d_b_documento AS archivo_blob,
				 doc_resp.d_n_consec AS consecutivo_documento,
				 g.d_v_nombre AS asignado,
				 fads.d_v_adscrip AS adscripcion,
				 '' AS area_ayuda,
				 NULL AS pk_i_asunto
			FROM d_ticket d
			INNER JOIN c_respuesta e
					ON d.pk_i_respuesta = e.pk_i_respuesta
			LEFT JOIN c_usuario f
					ON d.c_n_usucap = f.c_i_usuario
			LEFT JOIN c_adscrip fads
					ON f.c_i_adscri = fads.c_i_adscrip
			LEFT JOIN c_usuario g
					ON d.c_i_numemp = g.c_i_usuario
			LEFT JOIN (
					SELECT pk_i_ticket, pk_i_anio, c_n_usucap, d_f_fechcap, d_v_nomdocto, d_b_documento, d_n_consec
					FROM d_documento
					WHERE pk_i_tipodoc = 2 -- RESPUESTA
						AND d_b_documento IS NOT NULL
			) doc_resp
					ON d.pk_i_ticket = doc_resp.pk_i_ticket
					AND d.pk_i_anio = doc_resp.pk_i_anio
					AND d.c_n_usucap = doc_resp.c_n_usucap
					AND d.d_f_fechcap = doc_resp.d_f_fechcap
			LEFT JOIN m_ticket mt
					ON d.pk_i_ticket = mt.pk_i_ticket AND d.pk_i_anio = mt.pk_i_anio
			WHERE d.pk_i_ticket = :pk_i_ticket AND d.pk_i_anio = :pk_i_anio

			UNION ALL

			-- Evento de CIERRE
			SELECT
				 h.pk_i_ticket,
				 h.pk_i_anio,
				 'CERRADO' AS tipo_evento,
				 h.c_i_numemp AS actor,
				 i.d_v_nombre AS nombre_actor,
				 h.d_f_fechcierre AS fecha_evento,
				 '' AS descripcion,
				 '' AS documento,
				 NULL AS archivo_blob,
				 NULL AS consecutivo_documento,
				 '' AS asignado,
				 iads.d_v_adscrip AS adscripcion,
				 '' AS area_ayuda,
				 NULL AS pk_i_asunto
			FROM m_ticket h
			LEFT JOIN c_usuario i
					ON h.c_n_usucierre = i.c_i_usuario
			LEFT JOIN c_adscrip iads
					ON iads.c_i_adscrip = i.c_i_adscri
			WHERE h.pk_i_ticket = :pk_i_ticket AND h.pk_i_anio = :pk_i_anio AND h.d_f_fechcierre IS NOT NULL
			ORDER BY fecha_evento ASC;


												""", nativeQuery = true)
	List<HiloDTO> findDetalleTicket(@Param("pk_i_ticket") int pk_i_ticket, @Param("pk_i_anio") int pk_i_anio);

	@Query(value = """
			SELECT a.pk_i_ticket,
						 a.pk_i_anio,
						 a.d_f_fecha AS fecha,
						 p_sol.d_v_nombre AS solicitante,
						 a.d_v_asunto AS asunto,
						 d.d_v_nombre AS asignado,
						 a.pk_i_estado
			FROM m_ticket a
			INNER JOIN c_estado b ON a.pk_i_estado = b.pk_i_estado
			INNER JOIN c_usuario p_sol ON a.c_i_numemp = p_sol.c_i_usuario
			INNER JOIN c_usuario d ON a.c_i_numempasigna = d.c_i_usuario
			WHERE (:area IS NULL OR a.c_i_adscripasigna = :area)
				AND (:fechaIni IS NULL OR a.d_f_fecha >= :fechaIni)
				AND (:fechaFin IS NULL OR a.d_f_fecha <= :fechaFin)
				AND (:ticketId IS NULL OR a.pk_i_ticket = :ticketId)
				AND (:anio IS NULL OR a.pk_i_anio = :anio)
				AND (:asunto IS NULL OR a.d_v_asunto LIKE CONCAT('%', :asunto, '%'))
			ORDER BY a.pk_i_ticket DESC;
											""", nativeQuery = true)
	List<TicketDTO> findTicketsForm(@Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin,
			@Param("area") Integer area, @Param("ticketId") Integer ticketId, @Param("anio") Integer anio,
			@Param("asunto") String asunto);

	@Query(value = "SELECT CONCAT(b.nIdAdscripcionNva,' - ',b.tDescAdscripcion) AS area, "
			+ "SUM(CASE WHEN a.pk_i_estado = 1 THEN 1 ELSE 0 END) AS cantidad_abiertos, "
			+ "SUM(CASE WHEN a.pk_i_estado = 2 THEN 1 ELSE 0 END) AS cantidad_cerrados, "
			+ "COUNT(*) AS cantidad_totales " + "FROM m_ticket a "
			+ "INNER JOIN db_pbi_polban.tblRHAdscripcionesActual b ON a.c_i_adscripasigna = b.nIdAdscripcion "
			+ "WHERE a.pk_i_estado IN (1, 2) " + "AND (:fechaIni IS NULL OR a.d_f_fecha >= :fechaIni) "
			+ "AND (:fechaFin IS NULL OR a.d_f_fecha <= :fechaFin) "
			+ "GROUP BY b.nIdAdscripcion, b.tDescAdscripcion", nativeQuery = true)
	List<Object[]> findTicketsAsignados(@Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin);

	@Query(value = "SELECT CONCAT(b.nIdAdscripcionNva, ' - ', b.tDescAdscripcion) AS area, "
			+ "SUM(CASE WHEN a.pk_i_estado = 1 THEN 1 ELSE 0 END) AS cantidad_abiertos, "
			+ "SUM(CASE WHEN a.pk_i_estado = 2 THEN 1 ELSE 0 END) AS cantidad_cerrados, "
			+ "COUNT(*) AS cantidad_total " + "FROM db_pbi_polban.tblRHAdscripcionesActual b "
			+ "INNER JOIN m_ticket a ON a.c_i_adscrip = b.nIdAdscripcion " + "WHERE a.pk_i_estado IN (1, 2) "
			+ "AND (:fechaIni IS NULL OR a.d_f_fecha >= :fechaIni) "
			+ "AND (:fechaFin IS NULL OR a.d_f_fecha <= :fechaFin) "
			+ "GROUP BY b.nIdAdscripcion, b.tDescAdscripcion " + "ORDER BY b.nIdAdscripcion", nativeQuery = true)
	List<Object[]> findTicketsSolicitados(@Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin);

	@Query(value = """
			SELECT
			    CONCAT(b.tDescAdscripcion,' - ', c.d_v_asunto) AS area,
			    SUM(CASE WHEN a.pk_i_estado = 1 THEN 1 ELSE 0 END) AS cantidad_abiertos,
			    SUM(CASE WHEN a.pk_i_estado = 2 THEN 1 ELSE 0 END) AS cantidad_cerrados,
			    COUNT(*) AS cantidad_totales
			FROM m_ticket a
			INNER JOIN db_pbi_polban.tblRHAdscripcionesActual b
			    ON a.c_i_adscripasigna = b.nIdAdscripcion
			INNER JOIN c_asunto c
			    ON a.pk_i_asunto = c.pk_i_asunto
			WHERE a.pk_i_estado IN (1, 2)
			  AND (:fechaIni IS NULL OR a.d_f_fecha >= :fechaIni)
			  AND (:fechaFin IS NULL OR a.d_f_fecha <= :fechaFin)
			GROUP BY
			    b.nIdAdscripcion,
			    b.tDescAdscripcion,
			    c.d_v_asunto
			ORDER BY
			    b.tDescAdscripcion,
			    c.d_v_asunto;
														""", nativeQuery = true)
	List<Object[]> findTicketsAreaAyuda(@Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin);

	@Query(value = "SELECT * FROM v_recepcion "
			+ "WHERE c_i_adsc_recibe = :c_i_adscrip AND d_n_folio_arearec = :d_n_folio AND d_f_fech_recibio = :d_f_rec", nativeQuery = true)
	List<MemorandumDTO> findMemo(@Param("c_i_adscrip") Integer c_i_adscrip, @Param("d_n_folio") Integer d_n_folio,
			@Param("d_f_rec") Date d_f_rec);

	@Query(value = """
			SELECT
				pk_i_asunto,
				c_i_adscrip,
				CONCAT(b.tDescAdscripcion,' - ',d_v_asunto) as d_v_asunto,
				c_n_usucap,
				d_f_fechcap,
				w_v_status
			FROM c_asunto a
			INNER JOIN db_pbi_polban.tblRHAdscripcionesActual b ON (a.c_i_adscrip = b.nIdAdscripcion)
						      """, nativeQuery = true)
	List<Object[]> findAllAsuntosRaw();

}

package com.pbi.tickets.service;

import java.util.Date;
import java.util.List;

import com.pbi.tickets.dto.AsuntoDTO;
import com.pbi.tickets.dto.CabeceraDTO;
import com.pbi.tickets.dto.EstadisticasDTO;
import com.pbi.tickets.dto.HiloDTO;
import com.pbi.tickets.dto.MemorandumDTO;
import com.pbi.tickets.dto.TicketDTO;
import com.pbi.tickets.model.CTicket;

public interface ITicketService {
	void guardarTicket(TicketDTO ticketDTO);

	void cerrarTicket(Integer pk_i_ticket, Integer pk_i_anio, Integer c_n_usucap, Integer pk_i_estado);

	List<TicketDTO> buscarTodos(Integer c_i_usuario);

	TicketDTO obtenerTicketPorId(Integer pk_i_ticket, Integer pk_i_anio);

	CTicket buscarTicketPorId(Integer pk_i_ticket, Integer pk_i_anio);

	CabeceraDTO obtenerCabecera(Integer pk_i_ticket, Integer pk_i_anio);

	List<HiloDTO> obtenerHilo(Integer pk_i_ticket, Integer pk_i_anio);

	List<TicketDTO> buscarPorFiltros(Date fechaIni, Date fechaFin, Integer area, Integer pk_i_ticket,
			Integer pk_i_anio, String asunto);

	List<TicketDTO> buscarTicketsPorPlaca(Integer c_i_placa);

	List<MemorandumDTO> buscarMemo(Integer c_i_adscrip, Integer d_n_folio, Date d_f_rec);
	
	List<AsuntoDTO> obtenerAsuntos();

	List<EstadisticasDTO> obtenerCantidadUsuarios(String email);
	
	List<EstadisticasDTO> obtenerTicketsPorMes(String email);

}

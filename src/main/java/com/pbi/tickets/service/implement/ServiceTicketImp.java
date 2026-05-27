package com.pbi.tickets.service.implement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.tickets.dto.AsuntoDTO;
import com.pbi.tickets.dto.CabeceraDTO;
import com.pbi.tickets.dto.EstadisticasDTO;
import com.pbi.tickets.dto.HiloDTO;
import com.pbi.tickets.dto.MemorandumDTO;
import com.pbi.tickets.dto.TicketDTO;
import com.pbi.tickets.model.CDocumento;
import com.pbi.tickets.model.CTicket;
import com.pbi.tickets.model.CTicketPK;
import com.pbi.tickets.repositories.IDocumentoRepository;
import com.pbi.tickets.repositories.ITicketRepository;
import com.pbi.tickets.repositories.IUsuarioRepository;
import com.pbi.tickets.repositories.IVigenciasRepository;
import com.pbi.tickets.service.IEmailService;
import com.pbi.tickets.service.ITicketService;
import com.pbi.tickets.service.IUsuarioService;

@Service
public class ServiceTicketImp implements ITicketService {

	@Autowired
	private ITicketRepository repoTickets;

	@Autowired
	private IDocumentoRepository repoDocumento;

	@Autowired
	private IVigenciasRepository repoVigencias;

	@Autowired
	private IUsuarioRepository repoUsuarios;

	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IEmailService emailService;

	@Override
	public void guardarTicket(TicketDTO ticketDTO) {
		Integer ticketId = ticketDTO.getPk_i_ticket();
		Integer ticketAnio = ticketDTO.getPk_i_anio();

		CTicket ticket = null;

		if (ticketId != null && ticketAnio != null) {
			ticket = buscarTicketPorId(ticketId, ticketAnio);
			
		}

		if (ticket == null) {
			ticket = new CTicket();
			ticket.setPk_i_anio(LocalDate.now().getYear());
			ticket.setPk_i_ticket(repoTickets.findMaxTicketByAnio(LocalDate.now().getYear()) + 1);
			ticket.setD_f_fechcap(ticketDTO.getD_f_fechcap());
		}

		ticket.setD_f_fecha(new Date());
		ticket.setC_i_adscrip(ticketDTO.getC_i_adscrip());
		ticket.setC_i_numemp(ticketDTO.getC_i_numemp());
		ticket.setC_i_adscripasigna(ticketDTO.getC_i_adscripasigna());
		ticket.setC_i_numempasigna(ticketDTO.getC_i_numempasigna());
		ticket.setPk_i_asunto(ticketDTO.getPk_i_asunto());
		ticket.setD_v_asunto(ticketDTO.getD_v_asunto());
		ticket.setPk_i_estado(ticketDTO.getPk_i_estado() != null ? ticketDTO.getPk_i_estado() : 1);
		ticket.setPk_i_vigencia(ticketDTO.getPk_i_vigencia());
		ticket.setPk_i_folio(ticketDTO.getPk_i_folio() != null ? ticketDTO.getPk_i_folio() : 0);
		ticket.setPk_i_fuente(ticketDTO.getPk_i_fuente());
		ticket.setC_n_usucap(ticketDTO.getC_n_usucap());
		//ticket.setD_f_fechcap(ticketDTO.getD_f_fechcap());
		ticket.setW_v_status(ticketDTO.getW_v_status());

		repoTickets.save(ticket);
		
		//Se envía correo
		boolean esNuevo = (ticketId == null || ticketAnio == null);

		try {
		    String correoDestino = repoUsuarios.findCorreoByIdUsuario(ticketDTO.getC_i_numempasigna());

		    
		    if (correoDestino != null && !correoDestino.isEmpty()) {
		        String subject;
		        String body;

		        if (esNuevo) {
		            subject = "Ticket #" + ticket.getPk_i_ticket() + " creado exitosamente";
		            body = "Se ha creado tu ticket con folio " + ticket.getPk_i_ticket() +
		                   " del año " + ticket.getPk_i_anio() + ".\n" +
		                   "Asunto: " + ticket.getD_v_asunto() + "\n" +
		                   "Estatus: Abierto";
		        } else {
		            subject = "Ticket #" + ticket.getPk_i_ticket() + " actualizado";
		            body = "Tu ticket con folio " + ticket.getPk_i_ticket() +
		                   " del año " + ticket.getPk_i_anio() + " ha sido actualizado.\n" +
		                   "Asunto: " + ticket.getD_v_asunto() + "\n" +
		                   "Estatus actual: " + ticket.getPk_i_estado();
		        }

		        emailService.enviarCorreo(correoDestino, subject, body);
		    }

		} catch (Exception ex) {
		    System.out.println("Error al enviar correo: " + ex.getLocalizedMessage());
		}
		

		if (ticketDTO.getD_b_documento() != null && !ticketDTO.getD_b_documento().isEmpty()) {
			try {
				CDocumento doc = new CDocumento();
				doc.setPk_i_ticket(ticket.getPk_i_ticket());
				doc.setPk_i_anio(ticket.getPk_i_anio());
				doc.setD_v_nomdocto(ticketDTO.getD_v_nomdocto());
				doc.setD_n_consec(1);
				doc.setD_b_documento(ticketDTO.getD_b_documento().getBytes());
				doc.setPk_i_tipodoc(1);
				doc.setC_n_usucap(ticket.getC_n_usucap());
				doc.setD_f_fechcap(ticket.getD_f_fechcap());
				doc.setW_v_status(ticket.getW_v_status());

				repoDocumento.save(doc);

			} catch (Exception ex) {
				System.out
						.println("Error al agregar/actualizar registro en d_documento! :( " + ex.getLocalizedMessage());
			}
		}
	}

	@Override
	public List<TicketDTO> buscarTodos(Integer c_i_usuario) {
		List<TicketDTO> lista = repoTickets.findAllTickets(c_i_usuario);
		if(lista == null || lista.isEmpty()) {
			lista = repoTickets.findTicketsByUsuario(c_i_usuario);
		}
		
		return lista;
	}

	@Override
	public List<TicketDTO> buscarTicketsPorPlaca(Integer c_i_placa) {
		return repoTickets.findTicketsByUser(c_i_placa);
	}

	@Override
	public List<TicketDTO> buscarPorFiltros(Date fechaIni, Date fechaFin, Integer area, Integer pk_i_ticket,
			Integer pk_i_anio, String asunto) {
		return repoTickets.findTicketsForm(fechaIni, fechaFin, area, pk_i_ticket, pk_i_anio, asunto);
	}

	@Override
	public void cerrarTicket(Integer pk_i_ticket, Integer pk_i_anio, Integer c_n_usucap, Integer pk_i_estado) {
		CTicketPK ticketPK = new CTicketPK(pk_i_ticket, pk_i_anio);
		CTicket ticket = repoTickets.getById(ticketPK);
		ticket.setPk_i_estado(pk_i_estado);
		if (pk_i_estado != 2) {
			ticket.setD_f_fechcierre(null);
			ticket.setC_n_usucierre(null);
		} else {
			ticket.setD_f_fechcierre(new Date());
		}
		ticket.setC_n_usucierre(c_n_usucap);
		repoTickets.save(ticket);
		

	}

	@Override
	public List<MemorandumDTO> buscarMemo(Integer c_i_adscrip, Integer d_n_folio, Date d_f_rec) {
		return repoTickets.findMemo(c_i_adscrip, d_n_folio, d_f_rec);
	}

	public List<TicketDTO> convertirATicketDTO(List<CTicket> lista) {
		List<TicketDTO> listaDTO = new ArrayList<>();

		for (CTicket ticket : lista) {
			TicketDTO dto = new TicketDTO();
			dto.setPk_i_ticket(ticket.getPk_i_ticket());
			dto.setPk_i_anio(ticket.getPk_i_anio());
			dto.setD_f_fecha(ticket.getD_f_fecha());
			dto.setC_i_numemp(ticket.getC_i_numemp());
			dto.setC_i_adscrip(ticket.getC_i_adscrip());
			dto.setC_i_adscripasigna(ticket.getC_i_adscripasigna());
			dto.setC_i_numempasigna(ticket.getC_i_numempasigna());
			dto.setD_v_asunto(ticket.getD_v_asunto());
			dto.setPk_i_estado(ticket.getPk_i_estado());
			dto.setPk_i_vigencia(ticket.getPk_i_vigencia());
			dto.setPk_i_folio(ticket.getPk_i_folio());
			//dto.setPk_i_fuente(ticket.getPk_i_fuente());
			dto.setC_n_usucap(ticket.getC_n_usucap());
			dto.setD_f_fechcap(ticket.getD_f_fechcap());
			dto.setW_v_status(ticket.getW_v_status());
			dto.setD_v_nombre(serviceUsuario.obtenerNombre(ticket.getC_i_numemp()));
			dto.setD_v_nombreasigna(serviceUsuario.obtenerNombre(ticket.getC_i_numempasigna()));
			dto.setD_v_adscrip(repoVigencias.findNombreArea(ticket.getC_i_numemp()));
			dto.setD_v_adscripasigna(repoVigencias.findNombreArea(ticket.getC_i_numempasigna()));
			dto.setD_v_captura(serviceUsuario.obtenerNombre(ticket.getC_n_usucap()));

			listaDTO.add(dto);
		}

		return listaDTO;
	}

	public TicketDTO convertirATicketDTO(CTicket ticket) {
		TicketDTO dto = new TicketDTO();

		dto.setPk_i_ticket(ticket.getPk_i_ticket());
		dto.setPk_i_anio(ticket.getPk_i_anio());
		dto.setD_f_fecha(ticket.getD_f_fecha());
		dto.setC_i_numemp(ticket.getC_i_numemp());
		dto.setC_i_adscrip(ticket.getC_i_adscrip());
		dto.setC_i_adscripasigna(ticket.getC_i_adscripasigna());
		dto.setC_i_numempasigna(ticket.getC_i_numempasigna());
		dto.setD_v_asunto(ticket.getD_v_asunto());
		dto.setPk_i_estado(ticket.getPk_i_estado());
		dto.setPk_i_vigencia(ticket.getPk_i_vigencia());
		dto.setPk_i_folio(ticket.getPk_i_folio());
		//dto.setPk_i_fuente(ticket.getPk_i_fuente());
		dto.setC_n_usucap(ticket.getC_n_usucap());
		dto.setD_f_fechcap(ticket.getD_f_fechcap());
		dto.setW_v_status(ticket.getW_v_status());
		dto.setD_v_nombre(serviceUsuario.obtenerNombre(ticket.getC_i_numemp()));
		dto.setD_v_nombreasigna(serviceUsuario.obtenerNombre(ticket.getC_i_numempasigna()));
		dto.setD_v_captura(serviceUsuario.obtenerNombre(ticket.getC_n_usucap()));
		dto.setD_v_adscrip(repoVigencias.findNombreArea(ticket.getC_i_numemp()));
		dto.setD_v_adscripasigna(repoVigencias.findNombreArea(ticket.getC_i_numempasigna()));

		return dto;
	}


	@Override
	public List<EstadisticasDTO> obtenerCantidadUsuarios(String email) {
		List<Object[]> results = repoUsuarios.findCantidadTickets(email);
		return results.stream().map(row -> new EstadisticasDTO((String) row[0], ((Number) row[1]).intValue(),
				((Number) row[2]).intValue(), ((Number) row[3]).intValue())).collect(Collectors.toList());
	}
	
	@Override
	public List<EstadisticasDTO> obtenerTicketsPorMes(String email) {
	    List<Object[]> results = repoUsuarios.findTicketsPorMes(email);
	    return results.stream().map(row -> new EstadisticasDTO(
	        (String) row[0],                    // area (mes en texto)
	        ((Number) row[1]).intValue(),        // num_mes
	        ((Number) row[2]).intValue(),        // cantidad_abiertos
	        ((Number) row[3]).intValue(),        // cantidad_cerrados
	        0                                    // cantidad_totales no aplica aquí
	    )).collect(Collectors.toList());
	}


	@Override
	public CabeceraDTO obtenerCabecera(Integer pk_i_ticket, Integer pk_i_anio) {
		return repoTickets.findCabeceraTicket(pk_i_ticket, pk_i_anio);
	}

	@Override
	public List<HiloDTO> obtenerHilo(Integer pk_i_ticket, Integer pk_i_anio) {
		return repoTickets.findDetalleTicket(pk_i_ticket, pk_i_anio);
	}

	@Override
	public TicketDTO obtenerTicketPorId(Integer pk_i_ticket, Integer pk_i_anio) {
		TicketDTO ticket = repoTickets.findTicketById(pk_i_ticket, pk_i_anio);
		//ticket.setPk_i_asunto(repoTickets.findTipoAsunto(pk_i_ticket, pk_i_anio));
		return ticket;
	}

	@Override
	public CTicket buscarTicketPorId(Integer pk_i_ticket, Integer pk_i_anio) {
		CTicketPK pk = new CTicketPK();
		pk.setPk_i_ticket(pk_i_ticket);
		pk.setPk_i_anio(pk_i_anio);

		Optional<CTicket> ticketOpt = repoTickets.findById(pk);
		return ticketOpt.orElse(null);
	}

	@Override
	public List<AsuntoDTO> obtenerAsuntos() {
		List<Object[]> results = repoTickets.findAllAsuntosRaw();

		return results.stream().map(row -> new AsuntoDTO(((Number) row[0]).intValue(),
				row[1] != null ? ((Number) row[1]).intValue() : null, (String) row[2], ((Number) row[3]).intValue(),
				(java.sql.Timestamp) row[4], row[5] != null ? row[5].toString() : null)).collect(Collectors.toList());
	}

	


}

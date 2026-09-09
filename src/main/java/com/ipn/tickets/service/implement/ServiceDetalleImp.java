package com.ipn.tickets.service.implement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.tickets.dto.DetalleDTO;
import com.ipn.tickets.model.CDetalle;
import com.ipn.tickets.model.CDocumento;
import com.ipn.tickets.model.CDocumentoPK;
import com.ipn.tickets.model.CTicket;
import com.ipn.tickets.model.CTicketPK;
import com.ipn.tickets.repositories.IDetalleRepository;
import com.ipn.tickets.repositories.IDocumentoRepository;
import com.ipn.tickets.repositories.ITicketRepository;
import com.ipn.tickets.repositories.IVigenciasRepository;
import com.ipn.tickets.service.IDetalleService;

@Service
public class ServiceDetalleImp implements IDetalleService {

	@Autowired
	private IDetalleRepository repoDetalle;

	@Autowired
	private ITicketRepository repoTickets;

	@Autowired
	private IDocumentoRepository repoDocumento;

	@Autowired
	private IVigenciasRepository repoVigencias;

	@Override
	public void guardarDetalle(DetalleDTO detalleDTO) {
		CTicketPK pk_ticket = new CTicketPK(detalleDTO.getPk_i_ticket(), detalleDTO.getPk_i_anio());
		CTicket ticket = repoTickets.getById(pk_ticket);
		try {
			CDetalle detalle = new CDetalle();

			int consecDetalle = repoDetalle.findMaxDetalle(detalleDTO.getPk_i_ticket(), detalleDTO.getPk_i_anio());
			detalle.setPk_i_ticket(detalleDTO.getPk_i_ticket());
			detalle.setPk_i_anio(detalleDTO.getPk_i_anio());
			detalle.setD_n_consec(consecDetalle + 1);
			detalle.setPk_i_respuesta(detalleDTO.getPk_i_respuesta());
			if (detalleDTO.getPk_i_respuesta() == 1 || detalleDTO.getPk_i_respuesta() == 3) { // Respuesta o Nota
																								// Interna
				//detalle.setC_i_adscrip(repoVigencias.findAdscrip(detalleDTO.getC_n_usucap()));
				detalle.setC_i_numemp(detalleDTO.getC_n_usucap());
			} else { // Turnado
				//detalle.setC_i_adscrip(detalleDTO.getC_i_adscrip());
				detalle.setC_i_numemp(detalleDTO.getC_i_numemp());

				ticket.setC_i_adscripasigna(detalleDTO.getC_i_adscrip());
				ticket.setC_i_numempasigna(detalleDTO.getC_i_numemp());
				ticket.setPk_i_vigencia(repoVigencias.findVigencia(detalleDTO.getC_i_adscrip()));
				ticket.setPk_i_estado(1);
				
			}

			detalle.setD_v_comentario(detalleDTO.getD_v_comentario());
			detalle.setC_n_usucap(detalleDTO.getC_n_usucap());
			detalle.setD_f_fechcap(detalleDTO.getD_fechacap() != null ? detalleDTO.getD_fechacap() : new Date());
			detalle.setW_v_status(detalleDTO.getW_v_status());

			if (detalleDTO.getD_b_respuesta_form() != null && !detalleDTO.getD_b_respuesta_form().isEmpty()) {
				CDocumentoPK pk = new CDocumentoPK(detalleDTO.getPk_i_ticket(), detalleDTO.getPk_i_anio(), 1);
				CDocumento documento;

				// Verificar si ya existe el documento
				if (repoDocumento.existsById(pk)) {
					documento = repoDocumento.getById(pk); 
				} else {
					documento = new CDocumento(); // Creamos uno nuevo
					int consecDoc = repoDocumento.findMaxDoc(detalleDTO.getPk_i_ticket(), detalleDTO.getPk_i_anio());
					documento.setD_n_consec(consecDoc + 1);
					documento.setPk_i_ticket(detalleDTO.getPk_i_ticket());
					documento.setPk_i_anio(detalleDTO.getPk_i_anio());
					documento.setPk_i_tipodoc(2); // En este caso es respuesta
				}

				// Campos comunes (tanto para update como para nuevo)
				documento.setD_v_nomdocto(detalleDTO.getD_v_nomdocto());
				documento.setD_b_documento(detalleDTO.getD_b_respuesta_form().getBytes());
				documento.setC_n_usucap(detalleDTO.getC_n_usucap());
				documento.setD_f_fechcap(detalleDTO.getD_fechacap() != null ? detalleDTO.getD_fechacap() : new Date());
				documento.setW_v_status(detalleDTO.getW_v_status());

				repoDocumento.save(documento);
			}

			repoDetalle.save(detalle); // Primero guardamos en el detalle

			ticket.setPk_i_estado(1);
			repoTickets.save(ticket); // Después de haber guardado en el detalle, se guarda en el maestro

		} catch (Exception e) {
			System.out.println("Error al guardar el detalle :( " + e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

}

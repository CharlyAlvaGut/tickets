package com.ipn.tickets.service;

import com.ipn.tickets.dto.TicketDTO;
import com.ipn.tickets.model.CDocumento;
import com.ipn.tickets.model.CDocumentoPK;

public interface IDocumentoService {
	CDocumento obtenerDocumento(CDocumentoPK pk_doc);
}

package com.pbi.tickets.service;

import com.pbi.tickets.dto.TicketDTO;
import com.pbi.tickets.model.CDocumento;
import com.pbi.tickets.model.CDocumentoPK;

public interface IDocumentoService {
	CDocumento obtenerDocumento(CDocumentoPK pk_doc);
}

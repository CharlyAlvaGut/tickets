package com.pbi.tickets.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.tickets.dto.TicketDTO;
import com.pbi.tickets.model.CDocumento;
import com.pbi.tickets.model.CDocumentoPK;
import com.pbi.tickets.repositories.IDocumentoRepository;
import com.pbi.tickets.service.IDocumentoService;

@Service
public class ServiceDocumentoImp implements IDocumentoService{

	@Autowired
	private IDocumentoRepository repoDocumento;
	

	@Override
	public CDocumento obtenerDocumento(CDocumentoPK pk_doc) {
		Optional<CDocumento> optional = repoDocumento.findById(pk_doc);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}

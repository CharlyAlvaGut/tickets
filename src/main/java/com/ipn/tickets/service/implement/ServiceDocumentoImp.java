package com.ipn.tickets.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.tickets.dto.TicketDTO;
import com.ipn.tickets.model.CDocumento;
import com.ipn.tickets.model.CDocumentoPK;
import com.ipn.tickets.repositories.IDocumentoRepository;
import com.ipn.tickets.service.IDocumentoService;

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

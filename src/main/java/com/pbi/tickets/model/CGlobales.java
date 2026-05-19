package com.pbi.tickets.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pbi.tickets.repositories.ITicketRepository;

@ControllerAdvice
public class CGlobales {
	@Autowired
	private ITicketRepository repoTickets;

	@ModelAttribute("ticketsAsignados")
	public Integer getTicketsAsignados(Authentication auth) {
		if (auth == null) {
			return 0;
		}
		return repoTickets.findNumeroAsignados(auth.getName());
	}
}

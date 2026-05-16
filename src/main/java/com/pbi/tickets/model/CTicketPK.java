package com.pbi.tickets.model;

import java.io.Serializable;
import java.util.Objects;

public class CTicketPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pk_i_ticket;
	private Integer pk_i_anio;

	public CTicketPK() {
		super();
	}

	public CTicketPK(Integer pk_i_ticket, Integer pk_i_anio) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
	}

	public Integer getPk_i_ticket() {
		return pk_i_ticket;
	}

	public void setPk_i_ticket(Integer pk_i_ticket) {
		this.pk_i_ticket = pk_i_ticket;
	}

	public Integer getPk_i_anio() {
		return pk_i_anio;
	}

	public void setPk_i_anio(Integer pk_i_anio) {
		this.pk_i_anio = pk_i_anio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pk_i_anio, pk_i_ticket);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTicketPK other = (CTicketPK) obj;
		return Objects.equals(pk_i_anio, other.pk_i_anio) && Objects.equals(pk_i_ticket, other.pk_i_ticket);
	}
	
	

}

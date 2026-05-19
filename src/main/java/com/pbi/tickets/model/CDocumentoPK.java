package com.pbi.tickets.model;

import java.io.Serializable;
import java.util.Objects;

public class CDocumentoPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer pk_i_ticket;
	private Integer pk_i_anio;
	private Integer d_n_consec;
	
	
	public CDocumentoPK() {
		super();
	}

	public CDocumentoPK(Integer pk_i_ticket, Integer pk_i_anio, Integer d_n_consec) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.d_n_consec = d_n_consec;
	}



	public CDocumentoPK(Integer pk_i_ticket, Integer pk_i_anio) {
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
	
	

	public Integer getD_n_consec() {
		return d_n_consec;
	}



	public void setD_n_consec(Integer d_n_consec) {
		this.d_n_consec = d_n_consec;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(d_n_consec, pk_i_anio, pk_i_ticket);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDocumentoPK other = (CDocumentoPK) obj;
		return Objects.equals(d_n_consec, other.d_n_consec) && Objects.equals(pk_i_anio, other.pk_i_anio)
				&& Objects.equals(pk_i_ticket, other.pk_i_ticket);
	}
	
	
	
	
	
}

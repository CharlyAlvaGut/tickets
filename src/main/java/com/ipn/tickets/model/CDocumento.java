package com.ipn.tickets.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "d_documento")
@IdClass(CDocumentoPK.class) // Clave compuesta en la clase CDocumentoPK
public class CDocumento {
	@Id
	private Integer pk_i_ticket;
	@Id
	private Integer pk_i_anio;
	
	private Integer d_n_consec;
	private String d_v_nomdocto;
	private byte[] d_b_documento;
	private Integer pk_i_tipodoc;
	private Integer c_n_usucap;
	private Date d_f_fechcap;
	private String w_v_status;

	/*
	 * Estas columnas ya se están manejando directamente como campos de la entidad
	 * (@Id), así que no se manejarán desde la relación.
	 */
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "pk_i_ticket", referencedColumnName = "pk_i_ticket", insertable = false, updatable = false),
			@JoinColumn(name = "pk_i_anio", referencedColumnName = "pk_i_anio", insertable = false, updatable = false) })
	private CTicket ticket;

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

	public String getD_v_nomdocto() {
		return d_v_nomdocto;
	}

	public void setD_v_nomdocto(String d_v_nomdocto) {
		this.d_v_nomdocto = d_v_nomdocto;
	}

	public byte[] getD_b_documento() {
		return d_b_documento;
	}

	public void setD_b_documento(byte[] d_b_documento) {
		this.d_b_documento = d_b_documento;
	}
	

	public Integer getPk_i_tipodoc() {
		return pk_i_tipodoc;
	}

	public void setPk_i_tipodoc(Integer pk_i_tipodoc) {
		this.pk_i_tipodoc = pk_i_tipodoc;
	}
	

	public Integer getC_n_usucap() {
		return c_n_usucap;
	}

	public void setC_n_usucap(Integer c_n_usucap) {
		this.c_n_usucap = c_n_usucap;
	}

	public Date getD_f_fechcap() {
		return d_f_fechcap;
	}

	public void setD_f_fechcap(Date d_f_fechcap) {
		this.d_f_fechcap = d_f_fechcap;
	}

	public String getW_v_status() {
		return w_v_status;
	}

	public void setW_v_status(String w_v_status) {
		this.w_v_status = w_v_status;
	}
	
	public CTicket getTicket() {
		return ticket;
	}

	public void setTicket(CTicket ticket) {
		this.ticket = ticket;
	}
}

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
@Table(name = "d_ticket")
@IdClass(CDetallePK.class) // Clave compuesta en la clase CDetallePK
public class CDetalle {
	@Id
	private Integer pk_i_ticket;
	@Id
	private Integer pk_i_anio;
	@Id
	private Integer d_n_consec;

	private Integer pk_i_respuesta;
	//private Integer c_i_adscrip;
	private Integer c_i_numemp;
	private String d_v_comentario;
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

	

	public Integer getPk_i_respuesta() {
		return pk_i_respuesta;
	}

	public void setPk_i_respuesta(Integer pk_i_respuesta) {
		this.pk_i_respuesta = pk_i_respuesta;
	}
/*
	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}

	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
	}
*/
	public Integer getC_i_numemp() {
		return c_i_numemp;
	}

	public void setC_i_numemp(Integer c_i_numemp) {
		this.c_i_numemp = c_i_numemp;
	}

	public String getD_v_comentario() {
		return d_v_comentario;
	}

	public void setD_v_comentario(String d_v_comentario) {
		this.d_v_comentario = d_v_comentario;
	}

	public CTicket getTicket() {
		return ticket;
	}

	public void setTicket(CTicket ticket) {
		this.ticket = ticket;
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
}

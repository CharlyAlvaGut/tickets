package com.ipn.tickets.dto;

import java.util.Date;

public class CabeceraDTO {
	private Integer pk_i_ticket;
	private Integer pk_i_anio;
	private Date fecha_creacion;
	private String adscrip_sol;
	private String solicitante;
	private String adscrip_asigna;
	private String asignado;
	private String d_v_estado;
	private Integer horas;
	private String asunto;
	private String fuente;
	private Integer pk_i_estado;
	private String captura;

	
	
	public CabeceraDTO(Integer pk_i_ticket, Integer pk_i_anio, Date fecha_creacion, String adscrip_sol,
			String solicitante, String adscrip_asigna, String asignado, String d_v_estado, Integer horas, String asunto,
			String fuente, Integer pk_i_estado, String captura) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.fecha_creacion = fecha_creacion;
		this.adscrip_sol = adscrip_sol;
		this.solicitante = solicitante;
		this.adscrip_asigna = adscrip_asigna;
		this.asignado = asignado;
		this.d_v_estado = d_v_estado;
		this.horas = horas;
		this.asunto = asunto;
		this.fuente = fuente;
		this.pk_i_estado = pk_i_estado;
		this.captura = captura;
	}

	public CabeceraDTO(Integer pk_i_ticket, Integer pk_i_anio, Date fecha_creacion, String adscrip_sol,
			String solicitante, String adscrip_asigna, String asignado, String d_v_estado, Integer horas, String asunto,
			String fuente, Integer pk_i_estado) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.fecha_creacion = fecha_creacion;
		this.adscrip_sol = adscrip_sol;
		this.solicitante = solicitante;
		this.adscrip_asigna = adscrip_asigna;
		this.asignado = asignado;
		this.d_v_estado = d_v_estado;
		this.horas = horas;
		this.asunto = asunto;
		this.fuente = fuente;
		this.pk_i_estado = pk_i_estado;
	}

	public Integer getPk_i_ticket() {
		return pk_i_ticket;
	}

	
	public String getCaptura() {
		return captura;
	}

	public void setCaptura(String captura) {
		this.captura = captura;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getAdscrip_sol() {
		return adscrip_sol;
	}

	public void setAdscrip_sol(String adscrip_sol) {
		this.adscrip_sol = adscrip_sol;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getAdscrip_asigna() {
		return adscrip_asigna;
	}

	public void setAdscrip_asigna(String adscrip_asigna) {
		this.adscrip_asigna = adscrip_asigna;
	}

	public String getAsignado() {
		return asignado;
	}

	public void setAsignado(String asignado) {
		this.asignado = asignado;
	}

	public String getD_v_estado() {
		return d_v_estado;
	}

	public void setD_v_estado(String d_v_estado) {
		this.d_v_estado = d_v_estado;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public Integer getPk_i_estado() {
		return pk_i_estado;
	}

	public void setPk_i_estado(Integer pk_i_estado) {
		this.pk_i_estado = pk_i_estado;
	}

}

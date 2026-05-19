package com.pbi.tickets.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_ticket")
@IdClass(CTicketPK.class) 
public class CTicket {
	@Id
	private Integer pk_i_ticket;
	@Id
	private Integer pk_i_anio;
	private Date d_f_fecha;
	private Integer c_i_numemp;
	private Integer c_i_adscrip;
	private Integer c_i_adscripasigna;
	private Integer c_i_numempasigna;
	private Integer pk_i_asunto;
	private String d_v_asunto;
	private Integer pk_i_estado;
	private Integer pk_i_vigencia;
	private Integer pk_i_folio;
	private Integer pk_i_fuente;
	private Integer c_n_usucap;
	private Integer c_n_usucierre;
	private Date d_f_fechcierre;
	private Date d_f_fechcap;
	private String w_v_status;
	
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
	public Date getD_f_fecha() {
		return d_f_fecha;
	}
	public void setD_f_fecha(Date d_f_fecha) {
		this.d_f_fecha = d_f_fecha;
	}
	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}
	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
	}
	public Integer getC_i_numemp() {
		return c_i_numemp;
	}
	public void setC_i_numemp(Integer c_i_numemp) {
		this.c_i_numemp = c_i_numemp;
	}
	
	public Integer getC_i_adscripasigna() {
		return c_i_adscripasigna;
	}
	public void setC_i_adscripasigna(Integer c_i_adscripasigna) {
		this.c_i_adscripasigna = c_i_adscripasigna;
	}
	public Integer getC_i_numempasigna() {
		return c_i_numempasigna;
	}
	public void setC_i_numempasigna(Integer c_i_numempasigna) {
		this.c_i_numempasigna = c_i_numempasigna;
	}
	public Integer getPk_i_asunto() {
		return pk_i_asunto;
	}
	public void setPk_i_asunto(Integer pk_i_asunto) {
		this.pk_i_asunto = pk_i_asunto;
	}
	public String getD_v_asunto() {
		return d_v_asunto;
	}
	public void setD_v_asunto(String d_v_asunto) {
		this.d_v_asunto = d_v_asunto;
	}
	public Integer getPk_i_estado() {
		return pk_i_estado;
	}
	public void setPk_i_estado(Integer pk_i_estado) {
		this.pk_i_estado = pk_i_estado;
	}
	public Integer getPk_i_vigencia() {
		return pk_i_vigencia;
	}
	public void setPk_i_vigencia(Integer pk_i_vigencia) {
		this.pk_i_vigencia = pk_i_vigencia;
	}
	public Integer getPk_i_folio() {
		return pk_i_folio;
	}
	public void setPk_i_folio(Integer pk_i_folio) {
		this.pk_i_folio = pk_i_folio;
	}
	
	/**/
	public Integer getPk_i_fuente() {
		return pk_i_fuente;
	}
	public void setPk_i_fuente(Integer pk_i_fuente) {
		this.pk_i_fuente = pk_i_fuente;
	}
	//*/
	
	public Integer getC_n_usucap() {
		return c_n_usucap;
	}
	public void setC_n_usucap(Integer c_n_usucap) {
		this.c_n_usucap = c_n_usucap;
	}
	public Integer getC_n_usucierre() {
		return c_n_usucierre;
	}
	public void setC_n_usucierre(Integer c_n_usucierre) {
		this.c_n_usucierre = c_n_usucierre;
	}
	public Date getD_f_fechcierre() {
		return d_f_fechcierre;
	}
	public void setD_f_fechcierre(Date d_f_fechcierre) {
		this.d_f_fechcierre = d_f_fechcierre;
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

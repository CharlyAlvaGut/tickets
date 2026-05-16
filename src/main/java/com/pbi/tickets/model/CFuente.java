package com.pbi.tickets.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="c_fuente")
public class CFuente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_i_fuente;
	private String d_v_fuente;
	private Integer c_n_usucap;
	private Date d_f_fechcap;
	private String w_v_status;
	
	public Integer getPk_i_fuente() {
		return pk_i_fuente;
	}
	public void setPk_i_fuente(Integer pk_i_fuente) {
		this.pk_i_fuente = pk_i_fuente;
	}
	public String getD_v_fuente() {
		return d_v_fuente;
	}
	public void setD_v_fuente(String d_v_fuente) {
		this.d_v_fuente = d_v_fuente;
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

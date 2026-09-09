package com.ipn.tickets.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "d_usuarioadscrip")
@IdClass(CUsuarioAdscripPK.class)
public class CUsuarioAdscrip {
	@Id
	private Integer c_i_usuario;
	@Id
	private Integer c_i_adscrip;
	private Integer c_n_usucap;
	private Date d_f_fechcap;
	private String w_v_status;

	public Integer getC_i_usuario() {
		return c_i_usuario;
	}

	public void setC_i_usuario(Integer c_i_usuario) {
		this.c_i_usuario = c_i_usuario;
	}

	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}

	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
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

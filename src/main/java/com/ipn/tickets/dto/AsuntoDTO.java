package com.ipn.tickets.dto;

import java.util.Date;

public class AsuntoDTO {
	private Integer pk_i_asunto;
	private Integer c_i_adscrip;
	private String d_v_asunto;
	private Integer c_n_usucap;
	private Date d_f_fechcap;
	private String w_v_status;
	
	public AsuntoDTO() {
		super();
	}
	public AsuntoDTO(Integer pk_i_asunto, Integer c_i_adscrip, String d_v_asunto, Integer c_n_usucap, Date d_f_fechcap,
			String w_v_status) {
		super();
		this.pk_i_asunto = pk_i_asunto;
		this.c_i_adscrip = c_i_adscrip;
		this.d_v_asunto = d_v_asunto;
		this.c_n_usucap = c_n_usucap;
		this.d_f_fechcap = d_f_fechcap;
		this.w_v_status = w_v_status;
	}
	public Integer getPk_i_asunto() {
		return pk_i_asunto;
	}
	public void setPk_i_asunto(Integer pk_i_asunto) {
		this.pk_i_asunto = pk_i_asunto;
	}
	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}
	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
	}
	public String getD_v_asunto() {
		return d_v_asunto;
	}
	public void setD_v_asunto(String d_v_asunto) {
		this.d_v_asunto = d_v_asunto;
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

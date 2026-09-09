package com.ipn.tickets.dto;

import java.util.Date;

public class MemorandumDTO {
	private Integer pk_i_folio;
	private String d_v_numdocto;
	private Date f_d_fechcap;
	private Integer c_i_ads_recibe;
	private Integer d_n_folio_arearec;
	private Date d_f_fech_recibio;
	
	public MemorandumDTO() {
		super();
	}
	

	public MemorandumDTO(Integer pk_i_folio, String d_v_numdocto, Date f_d_fechcap, Integer c_i_ads_recibe,
			Integer d_n_folio_arearec, Date d_f_fech_recibio) {
		super();
		this.pk_i_folio = pk_i_folio;
		this.d_v_numdocto = d_v_numdocto;
		this.f_d_fechcap = f_d_fechcap;
		this.c_i_ads_recibe = c_i_ads_recibe;
		this.d_n_folio_arearec = d_n_folio_arearec;
		this.d_f_fech_recibio = d_f_fech_recibio;
	}


	public MemorandumDTO(Integer c_i_ads_recibe, Integer d_n_folio_arearec, Date d_f_fech_recibio) {
		super();
		this.c_i_ads_recibe = c_i_ads_recibe;
		this.d_n_folio_arearec = d_n_folio_arearec;
		this.d_f_fech_recibio = d_f_fech_recibio;
	}
	
	
	public Integer getPk_i_folio() {
		return pk_i_folio;
	}
	public void setPk_i_folio(Integer pk_i_folio) {
		this.pk_i_folio = pk_i_folio;
	}
	public String getD_v_numdocto() {
		return d_v_numdocto;
	}
	public void setD_v_numdocto(String d_v_numdocto) {
		this.d_v_numdocto = d_v_numdocto;
	}
	public Date getF_d_fechcap() {
		return f_d_fechcap;
	}
	public void setF_d_fechcap(Date f_d_fechcap) {
		this.f_d_fechcap = f_d_fechcap;
	}
	public Integer getC_i_ads_recibe() {
		return c_i_ads_recibe;
	}
	public void setC_i_ads_recibe(Integer c_i_ads_recibe) {
		this.c_i_ads_recibe = c_i_ads_recibe;
	}
	public Integer getD_n_folio_arearec() {
		return d_n_folio_arearec;
	}
	public void setD_n_folio_arearec(Integer d_n_folio_arearec) {
		this.d_n_folio_arearec = d_n_folio_arearec;
	}
	public Date getD_f_fech_recibio() {
		return d_f_fech_recibio;
	}
	public void setD_f_fech_recibio(Date d_f_fech_recibio) {
		this.d_f_fech_recibio = d_f_fech_recibio;
	}
	@Override
	public String toString() {
		return "MemorandumDTO [pk_i_folio=" + pk_i_folio + ", d_v_numdocto=" + d_v_numdocto + ", f_d_fechcap="
				+ f_d_fechcap + ", c_i_ads_recibe=" + c_i_ads_recibe + ", d_n_folio_arearec=" + d_n_folio_arearec
				+ ", d_f_fech_recibio=" + d_f_fech_recibio + "]";
	}
	
	
}

package com.ipn.tickets.dto;

public class AdscripcionDTO {
	private Integer c_i_adscrip;
	private Integer pk_i_vigencia;
	private String d_v_nombre;
	private Integer c_i_usuario;
	private Integer c_n_usucap;
	
	public AdscripcionDTO(Integer c_i_adscrip, Integer pk_i_vigencia, String d_v_nombre) {
		super();
		this.c_i_adscrip = c_i_adscrip;
		this.pk_i_vigencia = pk_i_vigencia;
		this.d_v_nombre = d_v_nombre;
	}
	
	public Integer getC_i_usuario() {
		return c_i_usuario;
	}

	public void setC_i_usuario(Integer c_i_usuario) {
		this.c_i_usuario = c_i_usuario;
	}
	

	public Integer getC_n_usucap() {
		return c_n_usucap;
	}

	public void setC_n_usucap(Integer c_n_usucap) {
		this.c_n_usucap = c_n_usucap;
	}

	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}
	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
	}
	public String getD_v_nombre() {
		return d_v_nombre;
	}
	public void setD_v_nombre(String d_v_nombre) {
		this.d_v_nombre = d_v_nombre;
	}

	public Integer getPk_i_vigencia() {
		return pk_i_vigencia;
	}

	public void setPk_i_vigencia(Integer pk_i_vigencia) {
		this.pk_i_vigencia = pk_i_vigencia;
	}
	
}

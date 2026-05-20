package com.pbi.tickets.dto;

import java.util.Date;

import com.pbi.tickets.model.CPerfil;

public class UsuarioDTO {
	private Integer c_i_usuario;
	private String d_v_nombre;
	private Integer c_i_adscrip;
	private String c_i_adscrip_1;
	private String c_i_adscripNva;
	private String d_v_adscrip;
	private String d_v_password;
	private CPerfil perfil;
	private Integer c_n_usucap;
	private Date d_f_fechcap = new Date();
	private String w_v_status = "A";
	private String d_v_email;
	
	

	public UsuarioDTO(Integer c_i_usuario, String d_v_nombre, Integer c_i_adscrip) {
		super();
		this.c_i_usuario = c_i_usuario;
		this.d_v_nombre = d_v_nombre;
		this.c_i_adscrip = c_i_adscrip;
	}

	public UsuarioDTO(Integer c_i_usuario, String d_v_nombre, String d_v_password, CPerfil perfil) {
		super();
		this.c_i_usuario = c_i_usuario;
		this.d_v_nombre = d_v_nombre;
		this.d_v_password = d_v_password;
		this.perfil = perfil;
	}

	public UsuarioDTO(Integer c_i_usuario, String d_v_nombre, Integer c_i_adscrip, String d_v_password,
			CPerfil perfil) {
		super();
		this.c_i_usuario = c_i_usuario;
		this.d_v_nombre = d_v_nombre;
		this.c_i_adscrip = c_i_adscrip;
		this.d_v_password = d_v_password;
		this.perfil = perfil;
	}

	public UsuarioDTO(Integer c_i_usuario, String d_v_nombre, Integer c_i_adscrip, String d_v_password, CPerfil perfil, String w_v_status, String d_v_email) {
		super();
		this.c_i_usuario = c_i_usuario;
		this.d_v_nombre = d_v_nombre;
		this.c_i_adscrip = c_i_adscrip;
		this.d_v_password = d_v_password;
		this.perfil = perfil;
		this.d_v_email = d_v_email;
		this.w_v_status = w_v_status;
	}

	public UsuarioDTO(Integer c_i_usuario, String d_v_nombre, Integer c_i_adscrip, String c_i_adscrip_1, String c_i_adscripNva,
			Date d_f_fechcap, String w_v_status) {
		super();
		this.c_i_usuario = c_i_usuario;
		this.d_v_nombre = d_v_nombre;
		this.c_i_adscrip = c_i_adscrip;
		this.c_i_adscrip_1 = c_i_adscrip_1;
		this.c_i_adscripNva = c_i_adscripNva;
		this.d_f_fechcap = d_f_fechcap;
		this.w_v_status = w_v_status;
	}

	public UsuarioDTO() {
		super();
	}

	public String getD_v_adscrip() {
		return d_v_adscrip;
	}

	public void setD_v_adscrip(String d_v_adscrip) {
		this.d_v_adscrip = d_v_adscrip;
	}

	public Integer getC_i_usuario() {
		return c_i_usuario;
	}

	public void setC_i_usuario(Integer c_i_usuario) {
		this.c_i_usuario = c_i_usuario;
	}

	public String getD_v_nombre() {
		return d_v_nombre;
	}

	public void setD_v_nombre(String d_v_nombre) {
		this.d_v_nombre = d_v_nombre;
	}

	public String getD_v_password() {
		return d_v_password;
	}

	public void setD_v_password(String d_v_password) {
		this.d_v_password = d_v_password;
	}

	public CPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(CPerfil perfil) {
		this.perfil = perfil;
	}

	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}

	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
	}

	public String getC_i_adscripNva() {
		return c_i_adscripNva;
	}

	public void setC_i_adscripNva(String c_i_adscripNva) {
		this.c_i_adscripNva = c_i_adscripNva;
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

	public String getD_v_email() {
		return d_v_email;
	}

	public void setD_v_email(String d_v_email) {
		this.d_v_email = d_v_email;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [c_i_usuario=" + c_i_usuario + ", d_v_nombre=" + d_v_nombre + ", c_i_adscrip=" + c_i_adscrip
				+ ", d_v_password=" + d_v_password + ", perfil=" + perfil + ", c_n_usucap=" + c_n_usucap
				+ ", d_f_fechcap=" + d_f_fechcap + ", w_v_status=" + w_v_status + "]";
	}

}

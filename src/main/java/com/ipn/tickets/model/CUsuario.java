package com.ipn.tickets.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "c_usuario")
public class CUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_i_usuario;
	private String d_v_email;
	private String d_v_nombre;
	private String d_v_password;
	private Integer c_n_usucap;
	private Date d_f_fechcap;
	private String w_v_status;
	
	@ManyToOne
	@JoinColumn(name = "pk_i_perfil", nullable = false) // Llave foránea a pk_i_perfil y no puede ser nulo
	private CPerfil perfil;

	public Integer getC_i_usuario() {
		return c_i_usuario;
	}

	public void setC_i_usuario(Integer c_i_usuario) {
		this.c_i_usuario = c_i_usuario;
	}
	
	
	public String getD_v_email() {
		return d_v_email;
	}

	public void setD_v_email(String d_v_email) {
		this.d_v_email = d_v_email;
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
/**/
	public CPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(CPerfil perfil) {
		this.perfil = perfil;
	}
//*/
	

	public Integer getC_n_usucap() {
		return c_n_usucap;
	}
/*
	public Set<CPerfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<CPerfil> perfiles) {
		this.perfiles = perfiles;
	}
*/
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

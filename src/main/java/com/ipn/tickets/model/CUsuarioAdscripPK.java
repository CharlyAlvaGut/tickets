package com.ipn.tickets.model;

import java.util.Objects;

public class CUsuarioAdscripPK {
	private Integer c_i_usuario;
	private Integer c_i_adscrip;
	
	public CUsuarioAdscripPK() {
		super();
	}
	
	
	public CUsuarioAdscripPK(Integer c_i_usuario) {
		super();
		this.c_i_usuario = c_i_usuario;
	}


	public CUsuarioAdscripPK(Integer c_i_usuario, Integer c_i_adscrip) {
		super();
		this.c_i_usuario = c_i_usuario;
		this.c_i_adscrip = c_i_adscrip;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(c_i_adscrip, c_i_usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CUsuarioAdscripPK other = (CUsuarioAdscripPK) obj;
		return Objects.equals(c_i_adscrip, other.c_i_adscrip) && Objects.equals(c_i_usuario, other.c_i_usuario);
	}
	
}

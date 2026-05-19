package com.pbi.tickets.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class RespuestaDTO {
	private Integer pk_i_ticket;
	private Integer pk_i_anio;
	private Integer d_n_consec;
	private String d_v_respuesta;
	private String d_v_nombre;
	private Integer c_n_usucap;
	private Date d_fechacap = new Date();
	private String w_v_status = "A";
	private byte[] d_b_respuesta = null;
	private MultipartFile d_b_respuesta_form = null;
	private String d_v_nomdocto;

	
	public RespuestaDTO() {
		super();
	}


	public RespuestaDTO(Integer d_n_consec, String d_v_respuesta, Integer c_n_usucap, Date d_fechacap,
			byte[] d_b_respuesta, String d_v_nomdocto) {
		super();
		this.d_n_consec = d_n_consec;
		this.d_v_respuesta = d_v_respuesta;
		this.c_n_usucap = c_n_usucap;
		this.d_fechacap = d_fechacap;
		this.d_b_respuesta = d_b_respuesta;
		this.d_v_nomdocto = d_v_nomdocto;
	}




	public RespuestaDTO(String d_v_respuesta, Integer c_n_usucap, Date d_fechacap, byte[] d_b_respuesta) {
		super();
		this.d_v_respuesta = d_v_respuesta;
		this.c_n_usucap = c_n_usucap;
		this.d_fechacap = d_fechacap;
		this.d_b_respuesta = d_b_respuesta;
	}


	public RespuestaDTO(String d_v_respuesta, Integer c_n_usucap, Date d_fechacap) {
		super();
		this.d_v_respuesta = d_v_respuesta;
		this.c_n_usucap = c_n_usucap;
		this.d_fechacap = d_fechacap;
	}

	public Integer getPk_i_ticket() {
		return pk_i_ticket;
	}
	
	

	public MultipartFile getD_b_respuesta_form() {
		return d_b_respuesta_form;
	}


	public void setD_b_respuesta_form(MultipartFile d_b_respuesta_form) {
		this.d_b_respuesta_form = d_b_respuesta_form;
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

	public Integer getD_n_consec() {
		return d_n_consec;
	}

	public void setD_n_consec(Integer d_n_consec) {
		this.d_n_consec = d_n_consec;
	}

	public String getD_v_respuesta() {
		return d_v_respuesta;
	}

	public void setD_v_respuesta(String d_v_respuesta) {
		this.d_v_respuesta = d_v_respuesta;
	}

	public String getD_v_nombre() {
		return d_v_nombre;
	}

	public void setD_v_nombre(String d_v_nombre) {
		this.d_v_nombre = d_v_nombre;
	}


	public byte[] getD_b_respuesta() {
		return d_b_respuesta;
	}


	public void setD_b_respuesta(byte[] d_b_respuesta) {
		this.d_b_respuesta = d_b_respuesta;
	}


	public Integer getC_n_usucap() {
		return c_n_usucap;
	}

	public void setC_n_usucap(Integer c_n_usucap) {
		this.c_n_usucap = c_n_usucap;
	}

	public Date getD_fechacap() {
		return d_fechacap;
	}

	public void setD_fechacap(Date d_fechacap) {
		this.d_fechacap = d_fechacap;
	}

	public String getW_v_status() {
		return w_v_status;
	}

	public void setW_v_status(String w_v_status) {
		this.w_v_status = w_v_status;
	}

	public String getD_v_nomdocto() {
		return d_v_nomdocto;
	}

	public void setD_v_nomdocto(String d_v_nomdocto) {
		this.d_v_nomdocto = d_v_nomdocto;
	}


	@Override
	public String toString() {
		return "RespuestaDTO [pk_i_ticket=" + pk_i_ticket + ", pk_i_anio=" + pk_i_anio + ", d_n_consec=" + d_n_consec
				+ ", d_v_respuesta=" + d_v_respuesta + ", c_n_usucap=" + c_n_usucap + ", d_fechacap=" + d_fechacap
				+ ", w_v_status=" + w_v_status + "]";
	}
}

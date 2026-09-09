package com.ipn.tickets.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class TicketDTO {
	private Integer pk_i_ticket;
	private Integer pk_i_anio;
	private Date fecha;
	private String solicitante;
	private String asunto;
	private String asignado;
	private Date d_f_fecha;
	private Integer c_i_numemp;
	private Integer c_i_adscrip;
	private Integer c_i_adscripasigna;
	private Integer c_i_numempasigna;
	private String d_v_nombre;
	private String d_v_nombreasigna;
	private String d_v_captura;
	private Integer pk_i_fuente;
	private String d_v_asunto;
	private String d_v_adscrip;
	private String d_v_adscripasigna;

	private Integer pk_i_estado;
	private Integer pk_i_vigencia;
	private Integer pk_i_folio;
	private Integer pk_i_asunto;
	
	private String d_v_nomdocto = null;
	private MultipartFile d_b_documento = null;
	private Integer c_n_usucap;
	private Date d_f_fechcap = new Date();
	private String w_v_status = "A";

	public TicketDTO() {
		super();
	}

	public TicketDTO(Integer pk_i_ticket, Integer pk_i_anio, Integer c_i_numemp, Integer c_i_adscrip,
			Integer c_i_adscripasigna, Integer c_i_numempasigna, Integer pk_i_fuente, String d_v_asunto,
			Integer pk_i_folio, Integer pk_i_vigencia, String d_v_nomdocto, byte[] d_b_documento) {
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.c_i_numemp = c_i_numemp;
		this.c_i_adscrip = c_i_adscrip;
		this.c_i_adscripasigna = c_i_adscripasigna;
		this.c_i_numempasigna = c_i_numempasigna;
		this.pk_i_fuente = pk_i_fuente;
		this.d_v_asunto = d_v_asunto;
		this.pk_i_folio = pk_i_folio;
		this.pk_i_vigencia = pk_i_vigencia;
		this.d_v_nomdocto = d_v_nomdocto;

		if (d_b_documento != null) {
			this.d_b_documento = new org.springframework.mock.web.MockMultipartFile(
					d_v_nomdocto != null ? d_v_nomdocto : "archivo", d_v_nomdocto != null ? d_v_nomdocto : "archivo",
					"application/octet-stream", d_b_documento);
		}
	}

	public TicketDTO(Integer pk_i_ticket, Integer pk_i_anio, Date fecha, String solicitante, String asunto,
			String asignado, Integer pk_i_estado) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.fecha = fecha;
		this.solicitante = solicitante;
		this.asunto = asunto;
		this.asignado = asignado;
		this.pk_i_estado = pk_i_estado;
	}

	public TicketDTO(Integer pk_i_ticket, Integer pk_i_anio, Date fecha, String solicitante, String asunto) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.fecha = fecha;
		this.solicitante = solicitante;
		this.asunto = asunto;
	}

	public TicketDTO(Integer pk_i_ticket, Integer pk_i_anio, Date d_f_fecha, Integer c_i_numemp, Integer c_i_adscrip,
			Integer c_i_adscripasigna, Integer c_i_numempasigna, String d_v_nombre, String d_v_nombreasigna,
			String d_v_asunto, String d_v_adscrip, String d_v_adscripasigna, Integer pk_i_fuente, Integer pk_i_estado,
			Integer pk_i_vigencia, Integer pk_i_folio, String d_v_nomdocto, MultipartFile d_b_documento,
			Integer c_n_usucap, Date d_f_fechcap, String w_v_status) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.d_f_fecha = d_f_fecha;
		this.c_i_numemp = c_i_numemp;
		this.c_i_adscrip = c_i_adscrip;
		this.c_i_adscripasigna = c_i_adscripasigna;
		this.c_i_numempasigna = c_i_numempasigna;
		this.d_v_nombre = d_v_nombre;
		this.d_v_nombreasigna = d_v_nombreasigna;
		this.d_v_asunto = d_v_asunto;
		this.d_v_adscrip = d_v_adscrip;
		this.d_v_adscripasigna = d_v_adscripasigna;
		this.pk_i_fuente = pk_i_fuente;
		this.pk_i_estado = pk_i_estado;
		this.pk_i_vigencia = pk_i_vigencia;
		this.pk_i_folio = pk_i_folio;
		this.d_v_nomdocto = d_v_nomdocto;
		this.d_b_documento = d_b_documento;
		this.c_n_usucap = c_n_usucap;
		this.d_f_fechcap = d_f_fechcap;
		this.w_v_status = w_v_status;
	}

	public TicketDTO(Integer pk_i_ticket, Integer pk_i_anio, Date d_f_fecha, Integer c_i_numemp,
			Integer c_i_numempasigna, String d_v_asunto) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.d_f_fecha = d_f_fecha;
		this.c_i_numemp = c_i_numemp;
		this.c_i_numempasigna = c_i_numempasigna;
		this.d_v_asunto = d_v_asunto;
	}

	public Integer getPk_i_asunto() {
		return pk_i_asunto;
	}

	public void setPk_i_asunto(Integer pk_i_asunto) {
		this.pk_i_asunto = pk_i_asunto;
	}

	public Integer getPk_i_ticket() {
		return pk_i_ticket;
	}

	public String getAsignado() {
		return asignado;
	}

	public void setAsignado(String asignado) {
		this.asignado = asignado;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Integer getC_i_numemp() {
		return c_i_numemp;
	}

	public void setC_i_numemp(Integer c_i_numemp) {
		this.c_i_numemp = c_i_numemp;
	}

	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}

	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
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

	public String getD_v_nombre() {
		return d_v_nombre;
	}

	public void setD_v_nombre(String d_v_nombre) {
		this.d_v_nombre = d_v_nombre;
	}

	public String getD_v_nombreasigna() {
		return d_v_nombreasigna;
	}

	public void setD_v_nombreasigna(String d_v_nombreasigna) {
		this.d_v_nombreasigna = d_v_nombreasigna;
	}

	public String getD_v_captura() {
		return d_v_captura;
	}

	public void setD_v_captura(String d_v_captura) {
		this.d_v_captura = d_v_captura;
	}

	public String getD_v_asunto() {
		return d_v_asunto;
	}

	public void setD_v_asunto(String d_v_asunto) {
		this.d_v_asunto = d_v_asunto;
	}

	public String getD_v_adscrip() {
		return d_v_adscrip;
	}

	public void setD_v_adscrip(String d_v_adscrip) {
		this.d_v_adscrip = d_v_adscrip;
	}

	public String getD_v_adscripasigna() {
		return d_v_adscripasigna;
	}

	public void setD_v_adscripasigna(String d_v_adscripasigna) {
		this.d_v_adscripasigna = d_v_adscripasigna;
	}

	public Integer getPk_i_fuente() {
		return pk_i_fuente;
	}

	public void setPk_i_fuente(Integer pk_i_fuente) {
		this.pk_i_fuente = pk_i_fuente;
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

	public String getD_v_nomdocto() {
		return d_v_nomdocto;
	}

	public void setD_v_nomdocto(String d_v_nomdocto) {
		this.d_v_nomdocto = d_v_nomdocto;
	}

	public MultipartFile getD_b_documento() {
		return d_b_documento;
	}

	public void setD_b_documento(MultipartFile d_b_documento) {
		this.d_b_documento = d_b_documento;
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

	@Override
	public String toString() {
		return "TicketDTO [pk_i_ticket=" + pk_i_ticket + ", pk_i_anio=" + pk_i_anio + ", d_f_fecha=" + d_f_fecha
				+ ", c_i_numemp=" + c_i_numemp + ", c_i_adscrip=" + c_i_adscrip + ", c_i_adscripasigna="
				+ c_i_adscripasigna + ", c_i_numempasigna=" + c_i_numempasigna + ", d_v_nombre=" + d_v_nombre
				+ ", d_v_nombreasigna=" + d_v_nombreasigna + ", d_v_asunto=" + d_v_asunto + ", d_v_adscrip="
				+ d_v_adscrip + ", d_v_adscripasigna=" + d_v_adscripasigna + ", pk_i_fuente=" + pk_i_fuente
				+ ", pk_i_estado=" + pk_i_estado + ", pk_i_vigencia=" + pk_i_vigencia + ", pk_i_folio=" + pk_i_folio
				+ ", d_v_nomdocto=" + d_v_nomdocto + ", d_b_documento=" + d_b_documento + ", c_n_usucap=" + c_n_usucap
				+ ", d_f_fechcap=" + d_f_fechcap + ", w_v_status=" + w_v_status + "]";
	}

}

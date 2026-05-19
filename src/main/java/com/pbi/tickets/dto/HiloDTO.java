package com.pbi.tickets.dto;

import java.util.Date;

public class HiloDTO {
	private Integer pk_i_ticket;
	private Integer pk_i_anio;
	private String tipo_evento;       
    private Integer actor;    
    private String nombre_actor;   
    private Date fecha_evento;
    private String descripcion;
    private String documento;
    private byte[] archivo_blob;
    private Integer consecutivo_documento;
    private String asignado;
    private String adscripcion;
    private String area_ayuda;
    private Integer pk_i_asunto;
    
	
	public HiloDTO(Integer pk_i_ticket, Integer pk_i_anio, String tipo_evento, Integer actor, String nombre_actor,
			Date fecha_evento, String descripcion, String documento, byte[] archivo_blob, Integer consecutivo_documento,
			String asignado, String adscripcion, String area_ayuda, Integer pk_i_asunto) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.tipo_evento = tipo_evento;
		this.actor = actor;
		this.nombre_actor = nombre_actor;
		this.fecha_evento = fecha_evento;
		this.descripcion = descripcion;
		this.documento = documento;
		this.archivo_blob = archivo_blob;
		this.consecutivo_documento = consecutivo_documento;
		this.asignado = asignado;
		this.adscripcion = adscripcion;
		this.area_ayuda = area_ayuda;
		this.pk_i_asunto = pk_i_asunto;
	}



	public HiloDTO(Integer pk_i_ticket, Integer pk_i_anio, String tipo_evento, Integer actor, String nombre_actor,
			Date fecha_evento, String descripcion, String documento, byte[] archivo_blob, Integer consecutivo_documento,
			String asignado, String adscripcion) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.tipo_evento = tipo_evento;
		this.actor = actor;
		this.nombre_actor = nombre_actor;
		this.fecha_evento = fecha_evento;
		this.descripcion = descripcion;
		this.documento = documento;
		this.archivo_blob = archivo_blob;
		this.consecutivo_documento = consecutivo_documento;
		this.asignado = asignado;
		this.adscripcion = adscripcion;
	}
	
	
	
	public HiloDTO(Integer pk_i_ticket, Integer pk_i_anio, String tipo_evento, Integer actor, String nombre_actor,
			Date fecha_evento, String descripcion, String documento, byte[] archivo_blob, Integer consecutivo_documento,
			String asignado, String adscripcion, String area_ayuda) {
		super();
		this.pk_i_ticket = pk_i_ticket;
		this.pk_i_anio = pk_i_anio;
		this.tipo_evento = tipo_evento;
		this.actor = actor;
		this.nombre_actor = nombre_actor;
		this.fecha_evento = fecha_evento;
		this.descripcion = descripcion;
		this.documento = documento;
		this.archivo_blob = archivo_blob;
		this.consecutivo_documento = consecutivo_documento;
		this.asignado = asignado;
		this.adscripcion = adscripcion;
		this.area_ayuda = area_ayuda;
	}



	public String getArea_ayuda() {
		return area_ayuda;
	}

	public void setArea_ayuda(String area_ayuda) {
		this.area_ayuda = area_ayuda;
	}



	public Integer getPk_i_ticket() {
		return pk_i_ticket;
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
	public String getTipo_evento() {
		return tipo_evento;
	}
	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}
	
	public Integer getActor() {
		return actor;
	}
	public void setActor(Integer actor) {
		this.actor = actor;
	}
	public String getNombre_actor() {
		return nombre_actor;
	}
	public void setNombre_actor(String nombre_actor) {
		this.nombre_actor = nombre_actor;
	}
	public Date getFecha_evento() {
		return fecha_evento;
	}
	public void setFecha_evento(Date fecha_evento) {
		this.fecha_evento = fecha_evento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public byte[] getArchivo_blob() {
		return archivo_blob;
	}
	public void setArchivo_blob(byte[] archivo_blob) {
		this.archivo_blob = archivo_blob;
	}
	
	public Integer getConsecutivo_documento() {
		return consecutivo_documento;
	}
	public void setConsecutivo_documento(Integer consecutivo_documento) {
		this.consecutivo_documento = consecutivo_documento;
	}
	public String getAsignado() {
		return asignado;
	}
	public void setAsignado(String asignado) {
		this.asignado = asignado;
	}
	public String getAdscripcion() {
		return adscripcion;
	}
	public void setAdscripcion(String adscripcion) {
		this.adscripcion = adscripcion;
	}
    
    
     
}

package com.ipn.tickets.dto;

public class EstadisticasDTO {
	private String area;
	private Integer num_mes;
	private Integer cantidad_abiertos;
	private Integer cantidad_cerrados;
	private Integer cantidad_totales;
	
	 
	public EstadisticasDTO(String area, Integer cantidad_abiertos, Integer cantidad_cerrados,
			Integer cantidad_totales) {
		super();
		this.area = area;
		this.cantidad_abiertos = cantidad_abiertos;
		this.cantidad_cerrados = cantidad_cerrados;
		this.cantidad_totales = cantidad_totales;
	}
	
	
	public EstadisticasDTO(String area, Integer num_mes, Integer cantidad_abiertos, Integer cantidad_cerrados, Integer cantidad_totales) {
	    super();
	    this.area = area;
	    this.num_mes = num_mes;
	    this.cantidad_abiertos = cantidad_abiertos;
	    this.cantidad_cerrados = cantidad_cerrados;
	    this.cantidad_totales = cantidad_totales;
	}

	


	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public Integer getNum_mes() {
		return num_mes;
	}

	public void setNum_mes(Integer num_mes) {
		this.num_mes = num_mes;
	}
	
	public Integer getCantidad_abiertos() {
		return cantidad_abiertos;
	}
	public void setCantidad_abiertos(Integer cantidad_abiertos) {
		this.cantidad_abiertos = cantidad_abiertos;
	}
	public Integer getCantidad_cerrados() {
		return cantidad_cerrados;
	}
	public void setCantidad_cerrados(Integer cantidad_cerrados) {
		this.cantidad_cerrados = cantidad_cerrados;
	}
	public Integer getCantidad_totales() {
		return cantidad_totales;
	}
	public void setCantidad_totales(Integer cantidad_totales) {
		this.cantidad_totales = cantidad_totales;
	}
	
	
}

package com.ipn.tickets.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "c_estado")
public class CEstado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_i_estado;
	private String d_v_estado;
	private Integer c_n_usucap;
	private Date d_f_fechcap;
	private String w_v_status;

	public Integer getPk_i_estado() {
		return pk_i_estado;
	}

	public void setPk_i_estado(Integer pk_i_estado) {
		this.pk_i_estado = pk_i_estado;
	}

	public String getD_v_estado() {
		return d_v_estado;
	}

	public void setD_v_estado(String d_v_estado) {
		this.d_v_estado = d_v_estado;
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
		return "CEstado [pk_i_estado=" + pk_i_estado + ", d_v_estado=" + d_v_estado + ", c_n_usucap=" + c_n_usucap
				+ ", d_f_fechcap=" + d_f_fechcap + ", w_v_status=" + w_v_status + "]";
	}

}

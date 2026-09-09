package com.ipn.tickets.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "c_vigencia")
public class CVigencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_i_vigencia;
	private Integer c_i_adscrip;
	private Integer d_i_horas;
	private Integer c_n_usucap;
	private Date d_f_fechcap;
	private String w_v_status;

	public Integer getPk_i_vigencia() {
		return pk_i_vigencia;
	}

	public void setPk_i_vigencia(Integer pk_i_vigencia) {
		this.pk_i_vigencia = pk_i_vigencia;
	}

	public Integer getC_i_adscrip() {
		return c_i_adscrip;
	}

	public void setC_i_adscrip(Integer c_i_adscrip) {
		this.c_i_adscrip = c_i_adscrip;
	}

	public Integer getD_i_horas() {
		return d_i_horas;
	}

	public void setD_i_horas(Integer d_i_horas) {
		this.d_i_horas = d_i_horas;
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
		return "CVigencia [pk_i_vigencia=" + pk_i_vigencia + ", c_i_adscrip=" + c_i_adscrip + ", d_i_horas=" + d_i_horas
				+ ", c_n_usucap=" + c_n_usucap + ", d_f_fechcap=" + d_f_fechcap + ", w_v_status=" + w_v_status + "]";
	}

}

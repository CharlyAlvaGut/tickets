package com.ipn.tickets.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="c_perfil")
public class CPerfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_i_perfil = 2; //Por defecto que sea STAFF
	private String d_v_perfil;
	/*
	@ManyToMany(mappedBy = "perfiles")
    private Set<CUsuario> usuarios = new HashSet<>();
	//*/
	
	public Integer getPk_i_perfil() {
		return pk_i_perfil;
	}
	public void setPk_i_perfil(Integer pk_i_perfil) {
		this.pk_i_perfil = pk_i_perfil;
	}
	public String getD_v_perfil() {
		return d_v_perfil;
	}
	public void setD_v_perfil(String d_v_perfil) {
		this.d_v_perfil = d_v_perfil;
	}
	
	@Override
	public String toString() {
		return "CPerfil [pk_i_perfil=" + pk_i_perfil + ", d_v_perfil=" + d_v_perfil + "]";
	}	
}

package com.pbi.tickets.service;

import java.util.List;

import com.pbi.tickets.dto.AdscripcionDTO;

public interface IUsuarioAdscripService {
	void guardarAdscrip(AdscripcionDTO adscrip);
	void eliminarAdscrip(Integer c_i_usuario, Integer c_i_adscrip);
	List<AdscripcionDTO> obtenerAreasDisponibles(Integer c_i_usuario);
	List<AdscripcionDTO> obtenerAreasAsignadas(Integer c_i_usuario);
}

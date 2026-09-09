package com.ipn.tickets.service;

import java.util.List;

import com.ipn.tickets.dto.AdscripcionDTO;

public interface IVigenciasService {
	List<AdscripcionDTO> obtenerAreas();
	List<AdscripcionDTO> obtenerAdscripcionesArea();
}

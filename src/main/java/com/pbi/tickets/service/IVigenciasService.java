package com.pbi.tickets.service;

import java.util.List;

import com.pbi.tickets.dto.AdscripcionDTO;

public interface IVigenciasService {
	List<AdscripcionDTO> obtenerAreas();
	List<AdscripcionDTO> obtenerAdscripcionesArea();
}

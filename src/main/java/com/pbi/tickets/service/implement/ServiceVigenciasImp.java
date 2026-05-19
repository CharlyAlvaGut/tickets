package com.pbi.tickets.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.tickets.dto.AdscripcionDTO;
import com.pbi.tickets.repositories.IVigenciasRepository;
import com.pbi.tickets.service.IVigenciasService;

@Service
public class ServiceVigenciasImp implements IVigenciasService{
	
	@Autowired
	private IVigenciasRepository repoVigencias;

	@Override
	public List<AdscripcionDTO> obtenerAreas() {
		return repoVigencias.findAreas();
	}

	@Override
	public List<AdscripcionDTO> obtenerAdscripcionesArea() {
		return repoVigencias.findAdscripArea();
	}

}

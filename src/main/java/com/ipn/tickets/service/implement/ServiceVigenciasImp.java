package com.ipn.tickets.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.tickets.dto.AdscripcionDTO;
import com.ipn.tickets.repositories.IVigenciasRepository;
import com.ipn.tickets.service.IVigenciasService;

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

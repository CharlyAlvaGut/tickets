package com.pbi.tickets.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.tickets.model.CFuente;
import com.pbi.tickets.repositories.IFuenteRepository;
import com.pbi.tickets.service.IFuenteService;

@Service
public class ServiceFuenteImp implements IFuenteService{

	@Autowired
	private IFuenteRepository repoFuente;
	
	@Override
	public List<CFuente> obtenerTodo() {
		return repoFuente.findAll();
	}

}

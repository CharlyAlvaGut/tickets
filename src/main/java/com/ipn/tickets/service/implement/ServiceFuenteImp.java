package com.ipn.tickets.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.tickets.model.CFuente;
import com.ipn.tickets.repositories.IFuenteRepository;
import com.ipn.tickets.service.IFuenteService;

@Service
public class ServiceFuenteImp implements IFuenteService{

	@Autowired
	private IFuenteRepository repoFuente;
	
	@Override
	public List<CFuente> obtenerTodo() {
		return repoFuente.findAll();
	}

}

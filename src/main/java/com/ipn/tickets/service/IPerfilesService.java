package com.ipn.tickets.service;

import java.util.List;

import com.ipn.tickets.model.CPerfil;

public interface IPerfilesService {
	List<CPerfil> buscarTodos();
	CPerfil buscarPorId(Integer id);
}

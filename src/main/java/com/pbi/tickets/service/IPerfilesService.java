package com.pbi.tickets.service;

import java.util.List;

import com.pbi.tickets.model.CPerfil;

public interface IPerfilesService {
	List<CPerfil> buscarTodos();
	CPerfil buscarPorId(Integer id);
}

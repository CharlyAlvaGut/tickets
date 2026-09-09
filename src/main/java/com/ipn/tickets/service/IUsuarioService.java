package com.ipn.tickets.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ipn.tickets.dto.UsuarioDTO;
import com.ipn.tickets.model.CUsuario;

public interface IUsuarioService {
	List<CUsuario> buscarTodos();
	//Page<CUsuario> buscarTodos(int page, int size);
	
	CUsuario buscarPorEmail(String email);
	
	CUsuario buscarPorPlaca(Integer c_i_placa);
	void guardar(UsuarioDTO usuarioDTO);
	void eliminar(Integer c_i_placa);
	String obtenerNombre(Integer c_i_placa);
	
	List<UsuarioDTO> obtenerPorPlaca(String placa);
	//List<UsuarioDTO> obtenerPorArea(String c_i_adscrip);
	List<UsuarioDTO> obtenerTodosArea();
	
	List<UsuarioDTO> obtenerTodosDTI();

	List<UsuarioDTO> obtenerPorArea(String c_i_adscrip);
	
	
	
}

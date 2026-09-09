package com.ipn.tickets.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.tickets.model.CPerfil;
import com.ipn.tickets.repositories.IPerfilesRepository;
import com.ipn.tickets.service.IPerfilesService;

@Service
public class ServicePerfilImp implements IPerfilesService{

	@Autowired
	private IPerfilesRepository repoPerfiles;
	
	@Override
	public List<CPerfil> buscarTodos() {
	    //return repoPerfiles.findAll(Sort.by(Sort.Direction.DESC, "pk_i_perfil"));
		return repoPerfiles.findAll();
	}

	@Override
	public CPerfil buscarPorId(Integer id) {
		Optional<CPerfil> perfiles = repoPerfiles.findById(id);
		if(perfiles.isPresent()) {
			return perfiles.get();
		}
		return null;
	}
	
}

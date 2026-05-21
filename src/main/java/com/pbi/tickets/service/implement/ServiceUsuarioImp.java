package com.pbi.tickets.service.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.tickets.dto.UsuarioDTO;
import com.pbi.tickets.model.CPerfil;
import com.pbi.tickets.model.CUsuario;
import com.pbi.tickets.model.CUsuarioAdscripPK;
import com.pbi.tickets.repositories.IUsuarioAdscripRepository;
import com.pbi.tickets.repositories.IUsuarioRepository;
import com.pbi.tickets.service.IUsuarioService;

@Service
public class ServiceUsuarioImp implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repoUsuarios;

	@Autowired
	private IUsuarioAdscripRepository repoUsuarioAdscrip;

	@Override
	public List<CUsuario> buscarTodos() {
		return repoUsuarios.findAll();
	}

	/*
	 * @Override public Page<CUsuario> buscarTodos(int page, int size) { Pageable
	 * pageable = PageRequest.of(page, size, Sort.by("d_v_nombre").ascending());
	 * 
	 * return repoUsuarios.findAll(pageable); }
	 */
	@Override
	public CUsuario buscarPorPlaca(Integer c_i_placa) {
		Optional<CUsuario> usuario = repoUsuarios.findById(c_i_placa);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}

	@Override
	public void guardar(UsuarioDTO usuarioDTO) {
	    CUsuario usuario;

	    // Si tiene ID, es edición; si no, es nuevo
	    if (usuarioDTO.getC_i_usuario() != null) {
	        Optional<CUsuario> existente = repoUsuarios.findById(usuarioDTO.getC_i_usuario());
	        usuario = existente.orElse(new CUsuario());
	    } else {
	        usuario = new CUsuario(); // AUTO_INCREMENT se encarga del ID
	    }

	    usuario.setD_v_nombre(usuarioDTO.getD_v_nombre());
	    usuario.setD_v_email(usuarioDTO.getD_v_email()); 
	    usuario.setPerfil(usuarioDTO.getPerfil());
	    usuario.setC_n_usucap(usuarioDTO.getC_n_usucap());
	    usuario.setD_f_fechcap(usuarioDTO.getD_f_fechcap());
	    usuario.setW_v_status(usuarioDTO.getW_v_status());

	    if (usuarioDTO.getD_v_password() != null && !usuarioDTO.getD_v_password().isEmpty()) {
	        usuario.setD_v_password(usuarioDTO.getD_v_password());
	    }

	    repoUsuarios.save(usuario);
	}

	@Override
	public void eliminar(Integer c_i_placa) {
		CUsuarioAdscripPK pk = new CUsuarioAdscripPK(c_i_placa);
		repoUsuarioAdscrip.deleteById(pk);
		repoUsuarios.deleteById(c_i_placa);

	}

	@Override
	public String obtenerNombre(Integer c_i_placa) {
		return repoUsuarios.findNombreByUsuario(c_i_placa);
	}

	@Override
	public List<UsuarioDTO> obtenerPorPlaca(String placa) {

		List<Object[]> results = repoUsuarios.findByWord(placa);

		return results.stream().map(row -> new UsuarioDTO(((Integer) row[0]).intValue(), // c_i_usuario
				(String) row[1],
				((Integer) row[2]).intValue(),
				((String) row[3]), 
				((String) row[4]),
				(Date) row[5], 
				String.valueOf(row[6]) 
		)).collect(Collectors.toList());
	}

	@Override
	public List<UsuarioDTO> obtenerPorArea(String c_i_adscrip) {

	    List<Object[]> results = repoUsuarios.findByArea(c_i_adscrip);

	    return results.stream().map(row -> {
	        CPerfil perfil = new CPerfil();
	        perfil.setPk_i_perfil(((Number) row[4]).intValue());

	        return new UsuarioDTO(
	            ((Number) row[0]).intValue(), // c_i_usuario
	            (String) row[1],              // d_v_nombre
	            ((Number) row[2]).intValue(), // c_i_adscrip
	            (String) row[3],              // d_v_password
	            perfil,                       // perfil
	            String.valueOf(row[5]),       // w_v_status
	            (String) row[6]               // d_v_email
	        );
	    }).collect(Collectors.toList());
	}

	@Override
	public List<UsuarioDTO> obtenerTodosArea() {
		return repoUsuarios.findPersonal();
	}

	@Override
	public List<UsuarioDTO> obtenerTodosDTI() {
		return repoUsuarios.findPersonalDTI();
	}

	@Override
	public CUsuario buscarPorEmail(String email) {
		return repoUsuarios.buscarPorEmail(email);
	}

}

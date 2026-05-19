package com.pbi.tickets.service.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbi.tickets.dto.AdscripcionDTO;
import com.pbi.tickets.model.CUsuarioAdscrip;
import com.pbi.tickets.model.CUsuarioAdscripPK;
import com.pbi.tickets.repositories.IUsuarioAdscripRepository;
import com.pbi.tickets.service.IUsuarioAdscripService;

@Service
public class ServiceUsuarioAdscripImp implements IUsuarioAdscripService{

	@Autowired
	private IUsuarioAdscripRepository repoUsuAdscrip;

	@Override
	public void guardarAdscrip(AdscripcionDTO adscripcionDTO) {
		CUsuarioAdscrip usuAdscrip = new CUsuarioAdscrip();
		usuAdscrip.setC_i_usuario(adscripcionDTO.getC_i_usuario());
		usuAdscrip.setC_i_adscrip(adscripcionDTO.getC_i_adscrip());
		usuAdscrip.setC_n_usucap(adscripcionDTO.getC_n_usucap());
		usuAdscrip.setD_f_fechcap(new Date());
		usuAdscrip.setW_v_status("A");
		
		repoUsuAdscrip.save(usuAdscrip);
		
	}

	@Override
	public List<AdscripcionDTO> obtenerAreasDisponibles(Integer c_i_usuario) {
		return repoUsuAdscrip.findAreasDisponibles(c_i_usuario);
	}

	@Override
	public List<AdscripcionDTO> obtenerAreasAsignadas(Integer c_i_usuario) {
		return repoUsuAdscrip.findAreasAsignadas(c_i_usuario);
	}

	@Override
	public void eliminarAdscrip(Integer c_i_usuario, Integer c_i_adscrip) {
	    CUsuarioAdscripPK pk = new CUsuarioAdscripPK(c_i_usuario, c_i_adscrip);
	    Optional<CUsuarioAdscrip> optional = repoUsuAdscrip.findById(pk);

	    if (optional.isPresent()) {
	        repoUsuAdscrip.delete(optional.get());
	    } else {
	        throw new IllegalArgumentException("No existe la adscripción para este usuario");
	    }
	}
	
	
}

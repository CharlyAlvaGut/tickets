package com.pbi.tickets.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pbi.tickets.dto.AdscripcionDTO;
import com.pbi.tickets.dto.UsuarioDTO;
import com.pbi.tickets.model.CPerfil;
import com.pbi.tickets.model.CUsuario;
import com.pbi.tickets.service.IPerfilesService;
import com.pbi.tickets.service.ITicketService;
import com.pbi.tickets.service.IUsuarioAdscripService;
import com.pbi.tickets.service.IUsuarioService;
import com.pbi.tickets.service.IVigenciasService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("usuarios")
public class jcUsuarios {

	@Autowired
	private IUsuarioService serviceUsuario;

	@Autowired
	private ITicketService serviceTicket;

	@Autowired
	private IPerfilesService servicePerfiles;

	@Autowired
	private IVigenciasService serviceVigencia;

	@Autowired
	private IUsuarioAdscripService serviceUsuarioAdscrip;

	@Autowired
	private PasswordEncoder passwwordEncoder;

	/* Método para listar los usuarios */
	@GetMapping("/lista")
	public String mostrarUsuarios(Model modelo) {
		return "usuarios/lista_usuarios";
	}

	/* Método para guardar un usuario */
	@PostMapping("/guardar")
	public String guardarUsuario(UsuarioDTO usuarioDTO, RedirectAttributes atributos, HttpSession session) {
		/**/
		CPerfil perfil = servicePerfiles.buscarPorId(usuarioDTO.getPerfil().getPk_i_perfil());
		String nombre = serviceUsuario.obtenerNombre(usuarioDTO.getC_i_usuario());
		if (usuarioDTO.getD_v_password().equals("")) {
			usuarioDTO.setD_v_password(null);
		} else {
			String password = passwwordEncoder.encode(usuarioDTO.getD_v_password());
			usuarioDTO.setD_v_password(password);
		}

		usuarioDTO.setD_v_nombre(nombre);
		usuarioDTO.setPerfil(perfil);

		if (session.getAttribute("usuario") != null) {
			CUsuario user = (CUsuario) session.getAttribute("usuario");
			usuarioDTO.setC_n_usucap(user.getC_i_usuario());
			serviceUsuario.guardar(usuarioDTO);
		}
		atributos.addFlashAttribute("mensaje", "El usuario ha sido guardado con éxito!!");
		
		//*/
		return "redirect:/usuarios/lista";
	}

	/* Método para eliminar al usuario */
	@GetMapping("/eliminar/{placa}")
	public String eliminarUsuario(@PathVariable("placa") int c_i_placa, RedirectAttributes atributos) {
		/*
		serviceUsuario.eliminar(c_i_placa);
		atributos.addFlashAttribute("mensaje", "El usuario ha sido eliminado con éxito!!");
		*/
		return "redirect:/usuarios/lista";
	}

	/* Método para listar los reportes por Usuario */
	@GetMapping("/reporte")
	public String obtenerReportes(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin, Model modelo) {
/*
		modelo.addAttribute("tickets", serviceTicket.obtenerCantidadAsignados(fechaIni, fechaFin));
		modelo.addAttribute("ticketsAreas", serviceTicket.obtenerCantidadSolicitados(fechaIni, fechaFin));
		modelo.addAttribute("ticketsUsuarios", serviceTicket.obtenerCantidadUsuarios(fechaIni, fechaFin));
		modelo.addAttribute("ticketsAyuda", serviceTicket.obtenerCantidadAreaAyuda(fechaIni, fechaFin));

		// Para que se mantengan seleccionadas las fechas en el formulario
		modelo.addAttribute("fechaIni", fechaIni);
		modelo.addAttribute("fechaFin", fechaFin);
*/
		return "usuarios/reporte_usuarios";
	}

	/* Método que envia el objeto en JSON para poder renderizarlo en la vista */
	@GetMapping("/buscar/{id}")
	@ResponseBody
	public CUsuario buscarPorId(@PathVariable("id") int idusuario) {
		
		CUsuario user = serviceUsuario.buscarPorPlaca(idusuario);
		user.setD_v_password("");
		return serviceUsuario.buscarPorPlaca(idusuario);
	}

	@GetMapping("/areasDisponibles/{usuario_id}")
	@ResponseBody
	public List<AdscripcionDTO> obtenerAreasDisponibles(@PathVariable("usuario_id") int idusuario) {
		return serviceUsuarioAdscrip.obtenerAreasDisponibles(idusuario);
	}

	@GetMapping("/areasAsignadas/{usuario_id}")
	@ResponseBody
	public List<AdscripcionDTO> obtenerAreasAsignadas(@PathVariable("usuario_id") int idusuario) {
		return serviceUsuarioAdscrip.obtenerAreasAsignadas(idusuario);
	}

	@PostMapping("/asignarArea")
	public ResponseEntity<?> asignarArea(@RequestBody AdscripcionDTO dto, HttpSession session) {
		if (session.getAttribute("usuario") != null) {
			CUsuario user = (CUsuario) session.getAttribute("usuario");
			dto.setC_n_usucap(user.getC_i_usuario());
		}
		try {
			
			if (dto.getC_i_usuario() == null || dto.getC_i_adscrip() == null) {
				return ResponseEntity.badRequest().body("El usuario o la adscripción no pueden ser nulos");
			}
			if (session.getAttribute("usuario") != null) {
				CUsuario user = (CUsuario) session.getAttribute("usuario");
				dto.setC_n_usucap(user.getC_i_usuario());
			}

			serviceUsuarioAdscrip.guardarAdscrip(dto); 
			return ResponseEntity.ok("Área asignada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al asignar el área: " + e.getMessage());
		}
	}
	
	@PostMapping("/quitarArea")
	public ResponseEntity<?> quitarArea(@RequestBody AdscripcionDTO dto, HttpSession session) {
		try {
			
			if (dto.getC_i_usuario() == null || dto.getC_i_adscrip() == null) {
				return ResponseEntity.badRequest().body("El usuario o la adscripción no pueden ser nulos");
			}
			
			serviceUsuarioAdscrip.eliminarAdscrip(dto.getC_i_usuario(), dto.getC_i_adscrip());
			return ResponseEntity.ok("Área eliminada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al eliminar el área: " + e.getMessage());
		}
	}

	/* Método para mandar al modelo los recursos que se necesiten en la vista */
	@ModelAttribute
	public void setGenericos(Model modelo) {
		/**/
		modelo.addAttribute("areas", serviceVigencia.obtenerAreas());
		modelo.addAttribute("usuarios", serviceUsuario.buscarTodos());
		modelo.addAttribute("perfiles", servicePerfiles.buscarTodos());
		//modelo.addAttribute("personal", serviceUsuario.obtenerTodosArea());
		//*/
		modelo.addAttribute("usuarioDTO", new UsuarioDTO());
	}

}

package com.pbi.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pbi.tickets.model.CUsuario;
import com.pbi.tickets.repositories.ITicketRepository;
import com.pbi.tickets.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class jcHome {
	@Autowired
	private IUsuarioService serviceUsuario;
	@Autowired
	private ITicketRepository repoTickets;

	@GetMapping("/login")
	public String mostrarLogin(HttpSession session, Model model,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			String msg = (String) session.getAttribute("msg");
			model.addAttribute("msg", msg);
			session.removeAttribute("msg");
		}
		return "loggin";
	}

	@GetMapping("/logout")
	public String cerrarSesion(HttpServletRequest request, HttpSession session) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		session = null;
		return "redirect:/login";
	}

	@GetMapping("/")
	public String mostrarIndex(Authentication auth, HttpSession session) {
		if (auth == null) {
			return "redirect:/login";
		}
		String email = auth.getName();
		System.out.println("Correo autenticado: " + email);
		System.out.println("Roles:");
		for (GrantedAuthority rol : auth.getAuthorities()) {
			System.out.println("-" + rol.getAuthority());
		}

		/*
		 * Primero se recomienda validar si existe un objeto en la sesión antes de crear
		 * uno
		 */
		/**/
		if (session.getAttribute("usuario") == null) {
			CUsuario usuario = serviceUsuario.buscarPorEmail(email);
			usuario.setD_v_password(null); // Para que no se pase la contraseña a la sesión
			session.setAttribute("usuario", usuario);
			
		}
		// */
		return "index";
	}

}

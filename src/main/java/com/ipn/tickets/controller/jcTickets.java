package com.ipn.tickets.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipn.tickets.dto.CabeceraDTO;
import com.ipn.tickets.dto.DetalleDTO;
import com.ipn.tickets.dto.HiloDTO;
import com.ipn.tickets.dto.MemorandumDTO;
import com.ipn.tickets.dto.TicketDTO;
import com.ipn.tickets.dto.UsuarioDTO;
import com.ipn.tickets.model.CDocumento;
import com.ipn.tickets.model.CDocumentoPK;
import com.ipn.tickets.model.CUsuario;
import com.ipn.tickets.service.IDetalleService;
import com.ipn.tickets.service.IDocumentoService;
import com.ipn.tickets.service.IFuenteService;
import com.ipn.tickets.service.ITicketService;
import com.ipn.tickets.service.IUsuarioService;
import com.ipn.tickets.service.IVigenciasService;

import jakarta.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Controller
@RequestMapping("ordenes")
public class jcTickets {

	@Autowired
	private IUsuarioService serviceUsuario;

	@Autowired
	private IVigenciasService serviceVigencia;

	@Autowired
	private IFuenteService serviceFuentes;

	@Autowired
	private ITicketService serviceTickets;

	@Autowired
	private IDetalleService serviceDetalle;

	@Autowired
	private IDocumentoService serviceDocumento;

	@Autowired
	private DataSource dataSource;

	@Value("${reporte.imagen.path}")
	private String rutaImagen;
	
	@Value("${reporte.imagen.path2}")
	private String rutaImagen2;

	@GetMapping("/crear")
	public String crearTickets(Model model) {
		model.addAttribute("titulo", "Nuevo Ticket");
		return "tickets/form_tickets";
	}

	@GetMapping("/detalle/{pk_i_ticket}/{pk_i_anio}")
	public String detalleTicket(@PathVariable("pk_i_ticket") int pk_i_ticket, @PathVariable("pk_i_anio") int pk_i_anio,
			Model modelo) {
		/**/
		CabeceraDTO cabecera = serviceTickets.obtenerCabecera(pk_i_ticket, pk_i_anio);
		List<HiloDTO> hilo = serviceTickets.obtenerHilo(pk_i_ticket, pk_i_anio);
		modelo.addAttribute("cabecera", cabecera);
		modelo.addAttribute("hilo", hilo);
		modelo.addAttribute("personal", serviceUsuario.obtenerTodosDTI());
		//*/
		modelo.addAttribute("detalleDTO", new DetalleDTO());
		return "tickets/detalle_tickets";
	}

	@GetMapping("/cerrar/{pk_i_estado}/{pk_i_ticket}/{pk_i_anio}")
	public String cerrarTicket(@PathVariable("pk_i_estado") int pk_i_estado,
			@PathVariable("pk_i_ticket") int pk_i_ticket, @PathVariable("pk_i_anio") int pk_i_anio,
			RedirectAttributes atributos, HttpSession session) {
		/**/
		CUsuario user = (CUsuario) session.getAttribute("usuario");
		if (user != null) {
			serviceTickets.cerrarTicket(pk_i_ticket, pk_i_anio, user.getC_i_usuario(), pk_i_estado);
		}
		
		//*/
		atributos.addFlashAttribute("mensaje", "El ticket ha sido cerrado con éxito!!!");
		//return "redirect:/ordenes/mostrar";
		return "redirect:/ordenes/detalle/" + pk_i_ticket + "/" + pk_i_anio;
	}

	@GetMapping("/mostrar")
	public String mostrarTickets(Model modelo, HttpSession session) {
		/**/
		CUsuario user = (CUsuario) session.getAttribute("usuario");
		List<TicketDTO> lista = serviceTickets.buscarTodos(user.getC_i_usuario());
		modelo.addAttribute("tickets", lista);
		modelo.addAttribute("areas", serviceVigencia.obtenerAreas());
		//*/
		
		modelo.addAttribute("titulo", "Buscar Tickets");
		modelo.addAttribute("texto", "Puedes filtrar por las siguientes opciones.");
		modelo.addAttribute("mostrarForm", true);
		return "tickets/lista_tickets";
	}

	@GetMapping("/mistickets")
	public String misTickets(Model modelo, HttpSession session) {
		/**/
		CUsuario user = (CUsuario) session.getAttribute("usuario");
		List<TicketDTO> lista = serviceTickets.buscarTicketsPorPlaca(user.getC_i_usuario());
		modelo.addAttribute("tickets", lista);
		//*/
		modelo.addAttribute("titulo", "Mis Tickets");
		modelo.addAttribute("texto", "Consultar tickets que te han asignado");
		modelo.addAttribute("mostrarForm", false);
		return "tickets/lista_tickets";
	}

	@PostMapping("/guardar")
	public String guardarTicket(HttpSession session, TicketDTO ticketDTO,
			@RequestParam(required = false) Integer pk_i_asunto, RedirectAttributes atributos) {

		if (session.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
/**/
		if (ticketDTO.getD_b_documento() != null && !ticketDTO.getD_b_documento().isEmpty()) {

			long maxSize = 1 * 1024 * 1024; // 1 MB

			if (ticketDTO.getD_b_documento().getSize() > maxSize) {
				atributos.addFlashAttribute("mensaje", "El archivo excede el tamaño máximo permitido (1 MB)");
				return "redirect:/ordenes/mostrar";
			}
		}

		CUsuario user = (CUsuario) session.getAttribute("usuario");

		ticketDTO.setC_n_usucap(user.getC_i_usuario());
		ticketDTO.setPk_i_asunto(pk_i_asunto);
		serviceTickets.guardarTicket(ticketDTO);
//*/
		atributos.addFlashAttribute("mensaje", "El Ticket ha sido abierto correctamente!!");

		return "redirect:/ordenes/mostrar";
	}

	/*
	 * @PostMapping("/guardar") public String guardarTicket(HttpSession session,
	 * TicketDTO ticketDTO,
	 * 
	 * @RequestParam(required = false) Integer pk_i_asunto, RedirectAttributes
	 * atributos) { System.out.println(ticketDTO); if
	 * (session.getAttribute("usuario") != null) { CUsuario user = (CUsuario)
	 * session.getAttribute("usuario");
	 * ticketDTO.setC_n_usucap(user.getC_i_usuario());
	 * ticketDTO.setPk_i_asunto(pk_i_asunto);
	 * serviceTickets.guardarTicket(ticketDTO);
	 * 
	 * } atributos.addFlashAttribute("mensaje",
	 * "El Ticket ha sido abierto correctamente!!"); return
	 * "redirect:/ordenes/mostrar"; }
	 */

	@PostMapping("/ordenes/actualizar")
	public String actualizarTicket(@ModelAttribute TicketDTO ticketDTO, RedirectAttributes redirectAttrs) {
		return "redirect:/tickets/ordenes/lista";
	}

	@GetMapping("/editar/{anio}/{ticketId}")
	public String editarTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("anio") Integer anio,
			Model model) {
		/**/
		TicketDTO ticket = serviceTickets.obtenerTicketPorId(ticketId, anio);
		ticket.setPk_i_ticket(ticketId);
		ticket.setPk_i_anio(anio);
		model.addAttribute("ticketDTO", ticket);
		model.addAttribute("areas", serviceVigencia.obtenerAreas());
		model.addAttribute("adscripciones", serviceVigencia.obtenerAdscripcionesArea());
		model.addAttribute("fuentes", serviceFuentes.obtenerTodo());
		//*/
		model.addAttribute("titulo", "Editar Ticket N°" + ticketId + "/" + anio);

		return "tickets/form_tickets";
	}

	@PostMapping("/respuesta")
	public String guardarRespuesta(DetalleDTO detalleDTO, @RequestParam Integer pk_i_ticket,
			@RequestParam Integer pk_i_anio, HttpSession session) {
		/**/
		if (session.getAttribute("usuario") != null) {
			CUsuario user = (CUsuario) session.getAttribute("usuario");
			detalleDTO.setC_n_usucap(user.getC_i_usuario());
			detalleDTO.setPk_i_respuesta(1); // El tipo 1 hace referencia a "RESPUESTA" en el catálogo
			serviceDetalle.guardarDetalle(detalleDTO);
		}
		//*/
		return "redirect:/ordenes/detalle/" + pk_i_ticket + "/" + pk_i_anio;
	}

	@PostMapping("/turnado")
	public String guardarTurnado(DetalleDTO detalleDTO, @RequestParam Integer pk_i_ticket,
			@RequestParam Integer pk_i_anio, HttpSession session) {
		/**/
		if (session.getAttribute("usuario") != null) {
			CUsuario user = (CUsuario) session.getAttribute("usuario");
			detalleDTO.setC_n_usucap(user.getC_i_usuario());
			detalleDTO.setPk_i_respuesta(2); // El tipo 2 hace referencia a "TURNADO" en el catálogo
			serviceDetalle.guardarDetalle(detalleDTO);

		}
		return "redirect:/ordenes/detalle/" + pk_i_ticket + "/" + pk_i_anio;

		//*/
		//return "redirect:/ordenes/mistickets";
	}

	@PostMapping("/nota")
	public String guardarNotaInterna(DetalleDTO detalleDTO, @RequestParam Integer pk_i_ticket,
			@RequestParam Integer pk_i_anio, HttpSession session) {
		/**/
		if (session.getAttribute("usuario") != null) {
			CUsuario user = (CUsuario) session.getAttribute("usuario");
			detalleDTO.setC_n_usucap(user.getC_i_usuario());
			detalleDTO.setPk_i_respuesta(3); // El tipo 3 hace referencia a "NOTA INTERNA" en el catálogo
			serviceDetalle.guardarDetalle(detalleDTO);

		}
		//*/
		return "redirect:/ordenes/detalle/" + pk_i_ticket + "/" + pk_i_anio;
	}

	@GetMapping("/buscar")
	public String buscar(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
			@RequestParam(required = false) Integer area, @RequestParam(required = false) Integer ticketId,
			@RequestParam(required = false) Integer anio, @RequestParam(required = false) String asunto, Model modelo) {

		/**/
		List<TicketDTO> lista = serviceTickets.buscarPorFiltros(fechaIni, fechaFin, area, ticketId, anio, asunto);
		modelo.addAttribute("tickets", lista);
		modelo.addAttribute("areas", serviceVigencia.obtenerAreas());
		//*/
		modelo.addAttribute("titulo", "Resultados de búsqueda");
		modelo.addAttribute("texto", "Estos son los tickets encontrados.");
		modelo.addAttribute("mostrarForm", true);

		return "tickets/lista_tickets";
	}

	@GetMapping("/{pk_i_ticket}/{pk_i_anio}/{tipo}/documento")
	public ResponseEntity<byte[]> verDocumento(@PathVariable("pk_i_ticket") int pk_i_ticket,
			@PathVariable("pk_i_anio") int pk_i_anio, @PathVariable("tipo") Integer d_n_consec) throws IOException {

		CDocumentoPK pk_doc = new CDocumentoPK(pk_i_ticket, pk_i_anio, d_n_consec);
		CDocumento documento = serviceDocumento.obtenerDocumento(pk_doc);

		byte[] archivo = documento.getD_b_documento();
		String nombreArchivo = documento.getD_v_nomdocto();

		if (archivo == null) {
			return ResponseEntity.notFound().build();
		}

		MediaType mediaType;

		if (nombreArchivo.toLowerCase().endsWith(".pdf")) {
			mediaType = MediaType.APPLICATION_PDF;
		} else if (nombreArchivo.toLowerCase().endsWith(".jpg") || nombreArchivo.toLowerCase().endsWith(".jpeg")) {
			mediaType = MediaType.IMAGE_JPEG;
		} else if (nombreArchivo.toLowerCase().endsWith(".png")) {
			mediaType = MediaType.IMAGE_PNG;
		} else {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		}

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=" + nombreArchivo)
				.contentType(mediaType).body(archivo);
	}

	@GetMapping("/reporte/{pk_i_ticket}/{pk_i_anio}")
	public ResponseEntity<byte[]> generarReporte(@PathVariable("pk_i_ticket") int pk_i_ticket,
			@PathVariable("pk_i_anio") int pk_i_anio, @RequestParam(name = "notas") int notas, HttpSession session) {

		// Cargar el archivo .jrxml
		InputStream jrxmlStream = getClass().getResourceAsStream("/static/assets/reportes/tickets.jrxml");
		if (jrxmlStream == null) {
			System.out.println("No se pudo cargar el archivo jrxml!!!");
			return ResponseEntity.status(500).body(null);
		}
		CUsuario user = (CUsuario) session.getAttribute("usuario");

		System.setProperty("net.sf.jasperreports.default.font.name", "DejaVu Sans");
		System.setProperty("net.sf.jasperreports.default.pdf.font.name", "DejaVuSans.ttf");
		System.setProperty("net.sf.jasperreports.default.pdf.encoding", "Identity-H");
		System.setProperty("net.sf.jasperreports.default.pdf.embedded", "true");

		Map<String, Object> parametros = new HashMap<>();
		parametros.put("p_pk_i_ticket", pk_i_ticket);
		parametros.put("p_pk_i_anio", pk_i_anio);
		parametros.put("p_imagen", rutaImagen);
		parametros.put("p_imagen_1", rutaImagen2);
		parametros.put("p_user", user.getD_v_nombre());
		parametros.put("p_notas", notas);
		//parametros.put("p_normado", "F46-4/7"); // Código duro

		try (Connection connection = DataSourceUtils.getConnection(dataSource)) {
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			return ResponseEntity.ok()
					.header("Content-Disposition",
							"inline; filename=Ticket N°" + pk_i_ticket + "-" + pk_i_anio + ".pdf")
					.contentType(MediaType.APPLICATION_PDF).body(pdf);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/obtenermemo")
	@ResponseBody
	public List<MemorandumDTO> obtenerMemo(@RequestParam("c_i_ads_recibe") Integer c_i_adscrip,
			@RequestParam("d_n_folio_arearec") Integer d_n_folio,
			@RequestParam("d_f_fech_recibio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d_f_rec, Model model) {
		return serviceTickets.buscarMemo(c_i_adscrip, d_n_folio, d_f_rec);
	}

	@GetMapping("/buscarea/{c_i_adscrip}")
	@ResponseBody
	public List<UsuarioDTO> obtenerPorArea(@PathVariable("c_i_adscrip") String c_i_adscrip) {
		return serviceUsuario.obtenerPorArea(c_i_adscrip);
	}

	@GetMapping("/buscaelementos")
	@ResponseBody
	public List<UsuarioDTO> obtenerPersonal(@RequestParam("palabra") String placa) {
		return serviceUsuario.obtenerPorPlaca(placa);
	}

	@GetMapping("{pk_i_ticket}/{pk_i_anio}/buscaelementos")
	@ResponseBody
	public List<UsuarioDTO> obtenerPersonalEdit(@RequestParam("palabra") String placa) {
		return serviceUsuario.obtenerPorPlaca(placa);
	}

	@ModelAttribute
	public String setGenericos(Model modelo) {
		modelo.addAttribute("ticketDTO", new TicketDTO());
		modelo.addAttribute("memoDTO", new MemorandumDTO());
		/**/
		//modelo.addAttribute("asuntos", serviceTickets.obtenerAsuntos());
		modelo.addAttribute("areas", serviceVigencia.obtenerAreas());
		modelo.addAttribute("adscripciones", serviceVigencia.obtenerAdscripcionesArea());
		modelo.addAttribute("fuentes", serviceFuentes.obtenerTodo());
		//*/
		return "tickets/form_tickets";
	}

}

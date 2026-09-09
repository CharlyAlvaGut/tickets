package com.ipn.tickets.security;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class UploadExceptionHandler {
	@ExceptionHandler({ MaxUploadSizeExceededException.class })
	public String handleUploadErrors(RedirectAttributes atributos) {
		atributos.addFlashAttribute("error", "El archivo debe pesar menos de 1MB! Intenta nuevamente");
		
		return "redirect:/ordenes/crear";
	}
}

package com.ipn.tickets.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ipn.tickets.service.IEmailService;

@Service
public class EmailServiceImp implements IEmailService {

    @Autowired
    @Qualifier("gmailSender")
    private JavaMailSender gmailSender;

    @Autowired
    @Qualifier("ipnSender")
    private JavaMailSender ipnSender;

    @Value("${spring.mail.gmail.username}")
    private String gmailFrom;

    @Value("${spring.mail.ipn.username}")
    private String ipnFrom;

    @Override
    public void enviarCorreo(String to, String subject, String text) {
        // Elige sender y remitente según dominio del destinatario
        boolean esIPN = to.endsWith("@alumno.ipn.mx") || to.endsWith("@ipn.mx");

        JavaMailSender sender = esIPN ? ipnSender  : gmailSender;
        String         from   = esIPN ? ipnFrom    : gmailFrom;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom(from);

        sender.send(message);
    }
}
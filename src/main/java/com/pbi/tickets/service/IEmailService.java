package com.pbi.tickets.service;


public interface IEmailService {
    void enviarCorreo(String to, String subject, String text);
}

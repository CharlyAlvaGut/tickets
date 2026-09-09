package com.ipn.tickets.service;


public interface IEmailService {
    void enviarCorreo(String to, String subject, String text);
}

package com.pbi.tickets.security;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class CMailConfig {

    // ── Gmail ──────────────────────────────────────────
    @Bean(name = "gmailSender")
    public JavaMailSender gmailSender(
            @Value("${spring.mail.gmail.host}")     String host,
            @Value("${spring.mail.gmail.port}")     int port,
            @Value("${spring.mail.gmail.username}") String user,
            @Value("${spring.mail.gmail.password}") String pass) {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(user);
        sender.setPassword(pass);

        Properties props = sender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return sender;
    }

    // ── IPN ────────────────────────────────────────────
    @Bean(name = "ipnSender")
    public JavaMailSender ipnSender(
            @Value("${spring.mail.ipn.host}")     String host,
            @Value("${spring.mail.ipn.port}")     int port,
            @Value("${spring.mail.ipn.username}") String user,
            @Value("${spring.mail.ipn.password}") String pass) {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(user);
        sender.setPassword(pass);

        Properties props = sender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return sender;
    }
}
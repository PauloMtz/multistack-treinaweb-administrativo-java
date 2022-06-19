package com.application.ediaristas.core.services.email.providers;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.application.ediaristas.core.services.email.adapters.EmailServiceAdapter;
import com.application.ediaristas.core.services.email.dtos.EmailServiceParamsDto;
import com.application.ediaristas.core.services.email.exceptions.EmailServiceException;

@Service
public class JavaMailSenderServiceProvider implements EmailServiceAdapter {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private TemplateEngine template;

    @Override
    public void enviarEmailComTemplateHtml(EmailServiceParamsDto params) {
        
        var mimeMessage = sender.createMimeMessage();
        var mimiMessageHelper = new MimeMessageHelper(mimeMessage);

        var context = new Context();
        context.setVariables(params.getProps());

        var html = template.process(params.getTemplate(), context);

        try {
            mimiMessageHelper.setFrom("nao-responda@ediaristas.com", "e-Diarista");
            mimiMessageHelper.setTo(params.getDestinatario());
            mimiMessageHelper.setSubject(params.getAssunto());
            mimiMessageHelper.setText(html, true);
        } catch (UnsupportedEncodingException e) {
            throw new EmailServiceException(e.getLocalizedMessage());
        } catch (MessagingException e) {
            throw new EmailServiceException(e.getLocalizedMessage());
        }

        sender.send(mimeMessage);
    }
    
}

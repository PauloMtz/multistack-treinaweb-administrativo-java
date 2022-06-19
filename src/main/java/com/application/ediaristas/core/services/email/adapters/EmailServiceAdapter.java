package com.application.ediaristas.core.services.email.adapters;

import com.application.ediaristas.core.services.email.dtos.EmailServiceParamsDto;

public interface EmailServiceAdapter {
    
    void enviarEmailComTemplateHtml(EmailServiceParamsDto params);
}

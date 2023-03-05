package com.victorreis.serviceproduto.dto;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

public class Error {

    private String codigo;
    private String mensagem;
    private String documentacao;

    public Error(@NotNull String codigo, @NotNull String mensagem, String urlDocumentation) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        documentacao = url + urlDocumentation;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDocumentacao() {
        return documentacao;
    }
}

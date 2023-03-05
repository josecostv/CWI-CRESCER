package com.br.cwi.IronSocial.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class MensagemValidator {

    @Value("280")
    private int tamanhoLimiteMensagem;

    public void validar(String mensagem){

        if(mensagem.trim().length() > tamanhoLimiteMensagem){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Limite de caracteres da mensagem excedido");
        }
    }
}

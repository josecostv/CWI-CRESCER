package com.br.cwi.IronSocial.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PublicacaoComentadaRequest {

    @NotNull
    private String mensagem;

    @NotNull
    private Long publicacaoId;

    @NotNull
    private Long usuarioId;

}

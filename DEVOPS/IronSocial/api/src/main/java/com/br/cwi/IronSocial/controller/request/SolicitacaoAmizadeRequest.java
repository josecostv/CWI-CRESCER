package com.br.cwi.IronSocial.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class SolicitacaoAmizadeRequest {

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long usuarioEnviouId;
}

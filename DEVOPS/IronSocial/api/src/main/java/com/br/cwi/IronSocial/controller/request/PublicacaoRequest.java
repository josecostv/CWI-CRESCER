package com.br.cwi.IronSocial.controller.request;

import com.br.cwi.IronSocial.domain.PublicacaoPermissao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class PublicacaoRequest {

    @NotNull
    private String mensagem;

    @NotNull
    private Long usuarioId;

    @NotNull
    private PublicacaoPermissao permissao;
}

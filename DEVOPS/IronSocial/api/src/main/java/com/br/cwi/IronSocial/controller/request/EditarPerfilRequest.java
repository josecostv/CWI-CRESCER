package com.br.cwi.IronSocial.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class EditarPerfilRequest {

    private String nome;

    private String apelido;

    private String urlImagemPerfil;
}

package com.br.cwi.IronSocial.security.controller.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioResponse {

    private Long id;

    private String nome;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    private String urlImagemPerfil;
}

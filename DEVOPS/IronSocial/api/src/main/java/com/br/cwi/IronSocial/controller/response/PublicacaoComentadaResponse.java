package com.br.cwi.IronSocial.controller.response;

import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublicacaoComentadaResponse {

    private Long id;

    private String mensagem;

    private PublicacaoResponse publicacao;

    private UsuarioResponse usuario;
}

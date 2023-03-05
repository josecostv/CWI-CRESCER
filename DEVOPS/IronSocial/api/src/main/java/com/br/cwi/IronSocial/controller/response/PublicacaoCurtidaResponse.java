package com.br.cwi.IronSocial.controller.response;

import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublicacaoCurtidaResponse {

    private Long id;

    private PublicacaoResponse publicacao;

    private UsuarioResponse usuario;
}

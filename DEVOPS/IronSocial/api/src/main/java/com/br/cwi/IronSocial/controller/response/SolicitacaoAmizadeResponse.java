package com.br.cwi.IronSocial.controller.response;

import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SolicitacaoAmizadeResponse {

    private Long id;

    private UsuarioResponse usuarioEnviou;
}

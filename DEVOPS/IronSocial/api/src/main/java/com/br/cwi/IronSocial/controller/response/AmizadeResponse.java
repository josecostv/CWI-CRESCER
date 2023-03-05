package com.br.cwi.IronSocial.controller.response;

import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AmizadeResponse {

    private Long id;

    private UsuarioResponse usuario;

    private UsuarioResponse amigo;
}

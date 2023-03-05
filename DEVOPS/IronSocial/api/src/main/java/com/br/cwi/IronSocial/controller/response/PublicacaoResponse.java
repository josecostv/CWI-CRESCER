package com.br.cwi.IronSocial.controller.response;

import com.br.cwi.IronSocial.domain.PublicacaoPermissao;
import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublicacaoResponse {

    private Long id;

    private String mensagem;

    private LocalDateTime dataPublicacao;

    private UsuarioResponse usuario;

    private PublicacaoPermissao permissao;
}

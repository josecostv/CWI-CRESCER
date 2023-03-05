package com.br.cwi.IronSocial.mapper;

import com.br.cwi.IronSocial.controller.request.SolicitacaoAmizadeRequest;
import com.br.cwi.IronSocial.controller.response.SolicitacaoAmizadeResponse;
import com.br.cwi.IronSocial.domain.SolicitacaoAmizade;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;

public class SolicitacaoAmizadeMapper {

    public static SolicitacaoAmizadeResponse toResponse(SolicitacaoAmizade entity) {

        return SolicitacaoAmizadeResponse.builder()
                .id(entity.getId())
                .usuarioEnviou(UsuarioMapper.toResponse(entity.getUsuarioEnviou()))

                .build();
    }

    public static SolicitacaoAmizade toEntity(SolicitacaoAmizadeRequest request) {
        return SolicitacaoAmizade.builder()
                .build();
    }
}

package com.br.cwi.IronSocial.mapper;

import com.br.cwi.IronSocial.controller.response.PublicacaoCurtidaResponse;
import com.br.cwi.IronSocial.domain.PublicacaoCurtida;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;

public class PublicacaoCurtidaMapper {

    public static PublicacaoCurtidaResponse toResponse(PublicacaoCurtida publicacaoCurtida) {

        return PublicacaoCurtidaResponse.builder()
                .id(publicacaoCurtida.getId())
                .publicacao(PublicacaoMapper.toResponse(publicacaoCurtida.getPublicacao()))
                .usuario(UsuarioMapper.toResponse(publicacaoCurtida.getUsuario()))
                .build();
    }
}

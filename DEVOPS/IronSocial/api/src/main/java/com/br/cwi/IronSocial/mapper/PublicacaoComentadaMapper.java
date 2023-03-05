package com.br.cwi.IronSocial.mapper;


import com.br.cwi.IronSocial.controller.request.PublicacaoComentadaRequest;
import com.br.cwi.IronSocial.controller.response.PublicacaoComentadaResponse;
import com.br.cwi.IronSocial.domain.PublicacaoComentada;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;

public class PublicacaoComentadaMapper {

    public static PublicacaoComentada toEntity(PublicacaoComentadaRequest request) {

        return PublicacaoComentada.builder()
                .mensagem(request.getMensagem())
                .build();
    }

    public static PublicacaoComentadaResponse toResponse(PublicacaoComentada publicacaoComentada) {

        return PublicacaoComentadaResponse.builder()
                .id(publicacaoComentada.getId())
                .usuario(UsuarioMapper.toResponse(publicacaoComentada.getUsuario()))
                .mensagem(publicacaoComentada.getMensagem())
                .publicacao(PublicacaoMapper.toResponse(publicacaoComentada.getPublicacao()))
                .build();
    }
}

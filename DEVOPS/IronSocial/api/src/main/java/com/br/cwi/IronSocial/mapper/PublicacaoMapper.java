package com.br.cwi.IronSocial.mapper;


import com.br.cwi.IronSocial.controller.request.PublicacaoRequest;
import com.br.cwi.IronSocial.controller.response.PublicacaoResponse;
import com.br.cwi.IronSocial.domain.Publicacao;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;

public class PublicacaoMapper {

    public static PublicacaoResponse toResponse(Publicacao publicacao) {

        return PublicacaoResponse.builder()
                .dataPublicacao(publicacao.getDataPublicacao())
                .id(publicacao.getId())
                .mensagem(publicacao.getMensagem())
                .usuario(UsuarioMapper.toResponse(publicacao.getUsuario()))
                .permissao(publicacao.getPermissao())
                .build();
    }

    public static Publicacao toEntity(PublicacaoRequest request) {

        return Publicacao.builder()
                .mensagem(request.getMensagem())
                .permissao(request.getPermissao())
                .build();
    }
}

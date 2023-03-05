package com.br.cwi.IronSocial.security.mapper;

import com.br.cwi.IronSocial.security.controller.request.UsuarioRequest;
import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import com.br.cwi.IronSocial.security.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {

        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        entity.setApelido(request.getApelido());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setUrlImagemPerfil(request.getUrlImagemPerfil());

        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setEmail(entity.getEmail());
        response.setApelido(entity.getApelido());
        response.setDataNascimento(entity.getDataNascimento());
        response.setUrlImagemPerfil(entity.getUrlImagemPerfil());
        return response;
    }
}

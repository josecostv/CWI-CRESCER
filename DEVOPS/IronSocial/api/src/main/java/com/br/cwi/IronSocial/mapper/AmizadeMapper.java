package com.br.cwi.IronSocial.mapper;

import com.br.cwi.IronSocial.controller.response.AmizadeResponse;
import com.br.cwi.IronSocial.domain.Amizade;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;

public class AmizadeMapper {

    public static AmizadeResponse toResponse(Amizade amizade) {

        return AmizadeResponse.builder()
                .id(amizade.getId())
                .usuario(UsuarioMapper.toResponse(amizade.getUsuario()))
                .amigo(UsuarioMapper.toResponse(amizade.getAmigo()))
                .build();
    }
}

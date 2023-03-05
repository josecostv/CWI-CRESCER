package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.response.PublicacaoResponse;
import com.br.cwi.IronSocial.mapper.PublicacaoMapper;
import com.br.cwi.IronSocial.repository.PublicacaoRepository;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPublicacoesService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Page<PublicacaoResponse> listarFeedPublicacao(Long id, Pageable pageable) {

        usuarioService.validaUsuarioAtual(id);

        return publicacaoRepository.findByUsuarioOuAmigos(id, pageable)
                .map(PublicacaoMapper::toResponse);
    }
}

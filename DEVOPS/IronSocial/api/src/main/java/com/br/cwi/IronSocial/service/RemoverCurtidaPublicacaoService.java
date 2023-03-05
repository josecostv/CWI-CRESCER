package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.request.PublicacaoCurtidaRequest;
import com.br.cwi.IronSocial.domain.PublicacaoCurtida;
import com.br.cwi.IronSocial.repository.PublicacaoCurtidaRepository;
import com.br.cwi.IronSocial.service.core.PublicacaoCurtidaService;
import com.br.cwi.IronSocial.service.core.PublicacaoService;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoverCurtidaPublicacaoService {

    @Autowired
    private PublicacaoCurtidaRepository publicacaoCurtidaRepository;

    @Autowired
    private PublicacaoCurtidaService publicacaoCurtidaService;

    @Autowired
    private PublicacaoService publicacaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public void remover(PublicacaoCurtidaRequest request) {

        publicacaoService.existePorId(request.getPublicacaoId());
        usuarioService.existePorId(request.getUsuarioId());

        publicacaoCurtidaService.validarUsuarioCurtiu(request.getPublicacaoId(), request.getUsuarioId());

        PublicacaoCurtida publicacaoCurtida = publicacaoCurtidaService.buscarPorPublicacaoIdEUsuarioId(request.getPublicacaoId(), request.getUsuarioId());

        publicacaoCurtidaRepository.deleteById(publicacaoCurtida.getId());
    }
}

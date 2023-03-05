package com.br.cwi.IronSocial.service;


import com.br.cwi.IronSocial.controller.request.PublicacaoRequest;
import com.br.cwi.IronSocial.controller.response.PublicacaoResponse;
import com.br.cwi.IronSocial.domain.Publicacao;
import com.br.cwi.IronSocial.mapper.PublicacaoMapper;
import com.br.cwi.IronSocial.repository.PublicacaoRepository;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import com.br.cwi.IronSocial.validator.MensagemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.time.LocalDateTime.now;

@Service
public class IncluirPublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MensagemValidator mensagemValidator;

    @Transactional
    public PublicacaoResponse incluir(PublicacaoRequest request) {

        Usuario usuario = usuarioService.buscarPorId(request.getUsuarioId());

        mensagemValidator.validar(request.getMensagem());

        Publicacao publicacao = PublicacaoMapper.toEntity(request);

        publicacao.setDataPublicacao(now());
        publicacao.setUsuario(usuario);

        publicacaoRepository.save(publicacao);

        return PublicacaoMapper.toResponse(publicacao);
    }
}

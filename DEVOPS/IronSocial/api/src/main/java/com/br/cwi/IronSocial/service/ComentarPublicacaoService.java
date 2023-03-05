package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.request.PublicacaoComentadaRequest;
import com.br.cwi.IronSocial.controller.response.PublicacaoComentadaResponse;
import com.br.cwi.IronSocial.domain.Publicacao;
import com.br.cwi.IronSocial.domain.PublicacaoComentada;
import com.br.cwi.IronSocial.mapper.PublicacaoComentadaMapper;
import com.br.cwi.IronSocial.repository.PublicacaoComentadaRepository;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.service.core.PublicacaoService;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import com.br.cwi.IronSocial.validator.MensagemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarPublicacaoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PublicacaoService publicacaoService;

    @Autowired
    private PublicacaoComentadaRepository publicacaoComentadaRepository;

    @Autowired
    private MensagemValidator mensagemValidator;

    @Transactional
    public PublicacaoComentadaResponse comentar(PublicacaoComentadaRequest request) {

        Publicacao publicacao = publicacaoService.buscarPorId(request.getPublicacaoId());
        Usuario usuario = usuarioService.buscarPorId(request.getUsuarioId());

        mensagemValidator.validar(request.getMensagem());

        PublicacaoComentada publicacaoComentada = PublicacaoComentadaMapper.toEntity(request);

        publicacaoComentada.setPublicacao(publicacao);
        publicacaoComentada.setUsuario(usuario);

        publicacaoComentadaRepository.save(publicacaoComentada);

        return PublicacaoComentadaMapper.toResponse(publicacaoComentada);
    }
}

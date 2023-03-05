package com.br.cwi.IronSocial.service;


import com.br.cwi.IronSocial.controller.request.PublicacaoCurtidaRequest;
import com.br.cwi.IronSocial.controller.response.PublicacaoCurtidaResponse;
import com.br.cwi.IronSocial.domain.Publicacao;
import com.br.cwi.IronSocial.domain.PublicacaoCurtida;
import com.br.cwi.IronSocial.mapper.PublicacaoCurtidaMapper;
import com.br.cwi.IronSocial.repository.PublicacaoCurtidaRepository;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.service.core.PublicacaoCurtidaService;
import com.br.cwi.IronSocial.service.core.PublicacaoService;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurtirPublicacaoService {

    @Autowired
    private PublicacaoCurtidaRepository publicacaoCurtidaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PublicacaoService publicacaoService;

    @Autowired
    private PublicacaoCurtidaService publicacaoCurtidaServiceService;

    @Transactional
    public PublicacaoCurtidaResponse curtir(PublicacaoCurtidaRequest request) {

        Publicacao publicacao = publicacaoService.buscarPorId(request.getPublicacaoId());
        Usuario usuario = usuarioService.buscarPorId(request.getUsuarioId());

        publicacaoCurtidaServiceService.validarUsuarioJaCurtiu(publicacao.getId(), usuario.getId());

        PublicacaoCurtida publicacaoCurtida = new PublicacaoCurtida();

        publicacaoCurtida.setPublicacao(publicacao);
        publicacaoCurtida.setUsuario(usuario);

        publicacaoCurtidaRepository.save(publicacaoCurtida);

        return PublicacaoCurtidaMapper.toResponse(publicacaoCurtida);
    }
}

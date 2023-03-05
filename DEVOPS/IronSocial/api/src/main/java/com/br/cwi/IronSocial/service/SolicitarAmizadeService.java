package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.request.SolicitacaoAmizadeRequest;
import com.br.cwi.IronSocial.controller.response.SolicitacaoAmizadeResponse;
import com.br.cwi.IronSocial.domain.SolicitacaoAmizade;
import com.br.cwi.IronSocial.mapper.SolicitacaoAmizadeMapper;
import com.br.cwi.IronSocial.repository.SolicitacaoAmizadeRepository;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.service.core.SolicitacaoAmizadeService;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitarAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private SolicitacaoAmizadeService solicitacaoAmizadeService;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public SolicitacaoAmizadeResponse solicitar(SolicitacaoAmizadeRequest request) {

        Usuario usuarioRecebeu = usuarioService.buscarPorId(request.getUsuarioId());
        Usuario usuarioEnviou = usuarioService.buscarPorId(request.getUsuarioEnviouId());

        solicitacaoAmizadeService.validarSolicitacaoRepetida(usuarioRecebeu, usuarioEnviou);

        SolicitacaoAmizade solicitacaoAmizade = SolicitacaoAmizadeMapper.toEntity(request);

        solicitacaoAmizade.setUsuarioEnviou(usuarioEnviou);
        solicitacaoAmizade.setUsuarioRecebeu(usuarioRecebeu);

        solicitacaoAmizadeRepository.save(solicitacaoAmizade);

        return SolicitacaoAmizadeMapper.toResponse(solicitacaoAmizade);
    }
}

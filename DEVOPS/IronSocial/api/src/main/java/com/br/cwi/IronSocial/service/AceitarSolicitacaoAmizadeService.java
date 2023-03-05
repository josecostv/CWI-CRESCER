package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.response.AmizadeResponse;
import com.br.cwi.IronSocial.domain.Amizade;
import com.br.cwi.IronSocial.domain.SolicitacaoAmizade;
import com.br.cwi.IronSocial.mapper.AmizadeMapper;
import com.br.cwi.IronSocial.repository.AmizadeRepository;
import com.br.cwi.IronSocial.repository.SolicitacaoAmizadeRepository;
import com.br.cwi.IronSocial.service.core.SolicitacaoAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AceitarSolicitacaoAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private SolicitacaoAmizadeService solicitacaoAmizadeService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Transactional
    public AmizadeResponse aceitar(Long idSolicitacao) {

        SolicitacaoAmizade solicitacaoAmizade = solicitacaoAmizadeService.buscarPorId(idSolicitacao);

        Amizade amizade = new Amizade();

        amizade.setAmigo(solicitacaoAmizade.getUsuarioEnviou());
        amizade.setUsuario(solicitacaoAmizade.getUsuarioRecebeu());

        amizadeRepository.save(amizade);

        solicitacaoAmizadeRepository.deleteById(idSolicitacao);

        return AmizadeMapper.toResponse(amizade);
    }
}

package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.repository.SolicitacaoAmizadeRepository;
import com.br.cwi.IronSocial.service.core.SolicitacaoAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecusarSolicitacaoAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private SolicitacaoAmizadeService solicitacaoAmizadeService;

    @Transactional
    public void recusar(Long id) {

        solicitacaoAmizadeService.existePorId(id);

        solicitacaoAmizadeRepository.deleteById(id);
    }
}

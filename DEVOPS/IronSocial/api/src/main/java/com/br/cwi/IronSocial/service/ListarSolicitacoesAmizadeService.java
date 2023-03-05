package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.response.SolicitacaoAmizadeResponse;
import com.br.cwi.IronSocial.mapper.SolicitacaoAmizadeMapper;
import com.br.cwi.IronSocial.repository.SolicitacaoAmizadeRepository;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarSolicitacoesAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<SolicitacaoAmizadeResponse> listar(Long id) {

        usuarioService.existePorId(id);

        return solicitacaoAmizadeRepository.findByUsuarioRecebeuId(id).stream()
                .map(SolicitacaoAmizadeMapper::toResponse)
                .collect(toList());
    }
}

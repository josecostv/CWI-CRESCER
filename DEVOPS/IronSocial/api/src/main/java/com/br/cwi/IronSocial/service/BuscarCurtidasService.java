package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.response.PublicacaoCurtidaResponse;
import com.br.cwi.IronSocial.mapper.PublicacaoCurtidaMapper;
import com.br.cwi.IronSocial.repository.PublicacaoCurtidaRepository;
import com.br.cwi.IronSocial.service.core.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BuscarCurtidasService {

    @Autowired
    private PublicacaoCurtidaRepository publicacaoCurtidaRepository;

    @Autowired
    private PublicacaoService publicacaoService;

    public List<PublicacaoCurtidaResponse> buscar(Long id) {

        publicacaoService.existePorId(id);

        return publicacaoCurtidaRepository.findAllByPublicacaoId(id).stream()
                .map(PublicacaoCurtidaMapper::toResponse)
                .collect(toList());
    }
}

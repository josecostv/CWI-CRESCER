package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.controller.response.PublicacaoComentadaResponse;
import com.br.cwi.IronSocial.mapper.PublicacaoComentadaMapper;
import com.br.cwi.IronSocial.repository.PublicacaoComentadaRepository;
import com.br.cwi.IronSocial.service.core.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarComentariosPublicacaoService {

    @Autowired
    private PublicacaoComentadaRepository publicacaoComentadaRepository;

    @Autowired
    private PublicacaoService publicacaoService;

    public List<PublicacaoComentadaResponse> listar(Long id) {

        publicacaoService.existePorId(id);

        return publicacaoComentadaRepository.findAllByPublicacaoId(id).stream()
                .map(PublicacaoComentadaMapper::toResponse)
                .collect(toList());
    }
}

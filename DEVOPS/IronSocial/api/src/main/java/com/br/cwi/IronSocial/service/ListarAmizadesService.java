package com.br.cwi.IronSocial.service;


import com.br.cwi.IronSocial.controller.response.AmizadeResponse;
import com.br.cwi.IronSocial.mapper.AmizadeMapper;
import com.br.cwi.IronSocial.repository.AmizadeRepository;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarAmizadesService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<AmizadeResponse> listarAmizades(Long id) {

        Usuario usuario = usuarioService.buscarPorId(id);

        return amizadeRepository.findAllByUsuarioOrAmigo(usuario, usuario).stream()
                .map(AmizadeMapper::toResponse)
                .collect(toList());
    }
}

package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;
import com.br.cwi.IronSocial.security.repository.UsuarioRepository;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioResponse buscar(Long id) {

        return UsuarioMapper.toResponse(usuarioService.buscarPorId(id));
    }
}

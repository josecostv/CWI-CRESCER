package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;
import com.br.cwi.IronSocial.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ListarTodosUsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<UsuarioResponse> listarPorNomeOuEmail(String text , Pageable pageable) {

        return usuarioRepository.findByNomeContainingOrEmailContainingAllIgnoreCase(text, text, pageable)
                .map(UsuarioMapper::toResponse);
    }
}

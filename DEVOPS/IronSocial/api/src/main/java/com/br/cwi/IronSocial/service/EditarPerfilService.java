package com.br.cwi.IronSocial.service;


import com.br.cwi.IronSocial.controller.request.EditarPerfilRequest;
import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.security.mapper.UsuarioMapper;
import com.br.cwi.IronSocial.security.repository.UsuarioRepository;
import com.br.cwi.IronSocial.service.core.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditarPerfilService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public UsuarioResponse editar(Long id, EditarPerfilRequest request) {

        Usuario usuario = usuarioService.buscarPorId(id);

        usuario.setNome(request.getNome());
        usuario.setApelido(request.getApelido());
        usuario.setUrlImagemPerfil(request.getUrlImagemPerfil());

        usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);
    }
}

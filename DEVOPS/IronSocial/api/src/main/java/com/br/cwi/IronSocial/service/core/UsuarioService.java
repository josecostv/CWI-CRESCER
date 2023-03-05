package com.br.cwi.IronSocial.service.core;

import com.br.cwi.IronSocial.domain.Publicacao;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.security.repository.UsuarioRepository;
import com.br.cwi.IronSocial.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public Usuario buscarPorId(Long id) {

        existePorId(id);

        return usuarioRepository.findById(id).get();
    }

    public void existePorId(Long id) {

        if(!usuarioRepository.existsById(id)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario não encontrado");
        }
    }

    public void validaUsuarioAtual(Long id) {
        existePorId(id);

        boolean isValido = id.equals(usuarioAutenticadoService.getId());

        if(!isValido){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario não autorizado");
        }
    }
}

package com.br.cwi.IronSocial.service.core;

import com.br.cwi.IronSocial.domain.SolicitacaoAmizade;
import com.br.cwi.IronSocial.repository.SolicitacaoAmizadeRepository;
import com.br.cwi.IronSocial.security.domain.Usuario;
import com.br.cwi.IronSocial.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class SolicitacaoAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    public SolicitacaoAmizade buscarPorId(Long id) {

        existePorId(id);

        return solicitacaoAmizadeRepository.findById(id).get();
    }

    public void existePorId(Long id) {

        if(!solicitacaoAmizadeRepository.existsById(id)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Solicitacao de amizade não encontrada");
        }
    }

    public void validarSolicitacaoRepetida(Usuario usuarioRecebeu, Usuario usuarioEnviou) {

        if(solicitacaoAmizadeRepository.existsByUsuarioRecebeuAndUsuarioEnviou(usuarioRecebeu, usuarioEnviou)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Solicitacao de amizade já foi solicitada");
        }
    }
}

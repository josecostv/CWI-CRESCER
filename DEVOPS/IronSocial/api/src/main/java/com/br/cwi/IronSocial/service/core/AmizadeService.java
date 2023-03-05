package com.br.cwi.IronSocial.service.core;

import com.br.cwi.IronSocial.domain.Amizade;
import com.br.cwi.IronSocial.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class AmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    public Amizade buscarPorId(Long id) {

        existePorId(id);

        return amizadeRepository.findById(id).get();
    }

    public void existePorId(Long id) {

        if(!amizadeRepository.existsById(id)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Amizade não encontrada");
        }
    }
}

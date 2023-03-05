package com.br.cwi.IronSocial.service;

import com.br.cwi.IronSocial.repository.AmizadeRepository;
import com.br.cwi.IronSocial.service.core.AmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoverAmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private AmizadeService amizadeService;

    @Transactional
    public void remover(Long id) {

        amizadeService.existePorId(id);

        amizadeRepository.deleteById(id);
    }
}

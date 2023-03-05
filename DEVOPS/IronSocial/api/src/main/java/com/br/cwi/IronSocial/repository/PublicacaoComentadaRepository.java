package com.br.cwi.IronSocial.repository;


import com.br.cwi.IronSocial.domain.PublicacaoComentada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PublicacaoComentadaRepository extends JpaRepository<PublicacaoComentada, Long> {

    List<PublicacaoComentada> findAllByPublicacaoId(Long id);

}

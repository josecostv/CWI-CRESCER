package com.br.cwi.IronSocial.repository;

import com.br.cwi.IronSocial.domain.SolicitacaoAmizade;
import com.br.cwi.IronSocial.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoAmizadeRepository extends JpaRepository<SolicitacaoAmizade, Long> {

    List<SolicitacaoAmizade> findByUsuarioRecebeuId(Long id);

    SolicitacaoAmizade findByUsuarioEnviouId(Long id);

    boolean existsByUsuarioRecebeuAndUsuarioEnviou(Usuario usuarioRecebeu, Usuario usuarioEnviou);
}

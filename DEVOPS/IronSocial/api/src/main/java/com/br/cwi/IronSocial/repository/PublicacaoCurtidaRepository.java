package com.br.cwi.IronSocial.repository;

import com.br.cwi.IronSocial.domain.PublicacaoCurtida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PublicacaoCurtidaRepository extends JpaRepository<PublicacaoCurtida, Long> {

    List<PublicacaoCurtida> findAllByPublicacaoId(Long id);

    boolean existsByPublicacaoIdAndUsuarioId(Long publicacaoId, Long usuarioId);

    Optional<PublicacaoCurtida> findByPublicacaoIdAndUsuarioId(Long publicacaoId, Long usuarioId);
}

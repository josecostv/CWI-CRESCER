package com.br.cwi.IronSocial.repository;

import com.br.cwi.IronSocial.domain.Publicacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

    Page<Publicacao> findByUsuarioIdOrderByDataPublicacaoDesc(Long id, Pageable pageable);

    @Query("SELECT p FROM Publicacao p " +
            "WHERE p.usuario.id = :idDoUsuario " +
            "OR p.usuario.id IN " +
            "(SELECT a.amigo.id FROM Amizade a " +
            "WHERE a.usuario.id = :idDoUsuario)")
    Page<Publicacao> findByUsuarioOuAmigos(@Param("idDoUsuario") Long idDoUsuario, Pageable pageable);

    Page<Publicacao> findAllByOrderByDataPublicacaoDesc(Pageable pageable);

}

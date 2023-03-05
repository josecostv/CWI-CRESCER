package com.br.cwi.IronSocial.repository;

import com.br.cwi.IronSocial.domain.Amizade;
import com.br.cwi.IronSocial.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {

    List<Amizade> findAllByUsuarioOrAmigo(Usuario usuario, Usuario amigo);


}


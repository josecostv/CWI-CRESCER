package com.br.cwi.IronSocial.domain;

import com.br.cwi.IronSocial.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String mensagem;

    @Enumerated(EnumType.STRING)
    private PublicacaoPermissao permissao;

    private LocalDateTime dataPublicacao;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "publicacao")
    private List<PublicacaoComentada> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "publicacao")
    private List<PublicacaoCurtida> curtidas = new ArrayList<>();
}

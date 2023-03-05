package com.br.cwi.IronSocial.domain;

import com.br.cwi.IronSocial.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class SolicitacaoAmizade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_recebeu_id")
    private Usuario usuarioRecebeu;

    @ManyToOne
    @JoinColumn(name = "usuario_enviou_id")
    private Usuario usuarioEnviou;
}

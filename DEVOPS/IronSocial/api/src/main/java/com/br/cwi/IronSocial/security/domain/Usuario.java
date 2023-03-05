package com.br.cwi.IronSocial.security.domain;

import com.br.cwi.IronSocial.domain.Amizade;
import com.br.cwi.IronSocial.domain.SolicitacaoAmizade;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private String apelido;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String senha;

    private String urlImagemPerfil;

    @Column(nullable = false)
    private boolean ativo;

    @OneToMany(mappedBy = "usuario")
    private List<Amizade> amizades = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioRecebeu")
    private List<SolicitacaoAmizade> solicitacoesAmizade = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }
}

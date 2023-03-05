package com.br.cwi.IronSocial.controller;


import com.br.cwi.IronSocial.controller.request.EditarPerfilRequest;
import com.br.cwi.IronSocial.controller.request.SolicitacaoAmizadeRequest;
import com.br.cwi.IronSocial.controller.response.AmizadeResponse;
import com.br.cwi.IronSocial.controller.response.PublicacaoResponse;
import com.br.cwi.IronSocial.controller.response.SolicitacaoAmizadeResponse;
import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import com.br.cwi.IronSocial.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/social")
public class SocialController {

    @Autowired
    private ListarTodosUsuariosService listarTodosUsuariosService;

    @Autowired
    private ListarAmizadesService listarAmizadesService;

    @Autowired
    private ListarPublicacoesService listarPublicacoesService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private EditarPerfilService editarPerfilService;

    @Autowired
    private BuscarPublicacoesUsuarioService buscarPublicacoesUsuarioService;

    @Autowired
    private RemoverAmizadeService removerAmizadeService;

    @Autowired
    private ListarSolicitacoesAmizadeService listarSolicitacoesAmizadeService;

    @Autowired
    private AceitarSolicitacaoAmizadeService aceitarSolicitacaoAmizadeService;

    @Autowired
    private RecusarSolicitacaoAmizadeService recusarSolicitacaoAmizadeService;

    @Autowired
    private SolicitarAmizadeService solicitarAmizadeService;

    @GetMapping("/pesquisar")
    public Page<UsuarioResponse> listarUsuariosFiltrados(@RequestParam String text, Pageable pageable){

        return listarTodosUsuariosService.listarPorNomeOuEmail(text, pageable);
    }

    @GetMapping("/{id}/feed")
    public Page<PublicacaoResponse> listarFeedPublicacao(@PathVariable Long id, Pageable pageable){

        return listarPublicacoesService.listarFeedPublicacao(id, pageable);
    }

    @GetMapping("/{id}")
    public UsuarioResponse buscarPerfil(@PathVariable Long id){

        return buscarUsuarioService.buscar(id);
    }
    @PutMapping("/{id}")
    public UsuarioResponse editarPerfil(@PathVariable Long id, @Valid @RequestBody EditarPerfilRequest request){

        return editarPerfilService.editar(id, request);
    }

    @GetMapping("/{id}/publicacoes")
    public Page<PublicacaoResponse> buscarPublicacoesUsuario(@PathVariable Long id, Pageable pageable){

        return buscarPublicacoesUsuarioService.buscar(id, pageable);
    }

    @GetMapping("/{id}/amizades")
    public List<AmizadeResponse> listarAmizades(@PathVariable Long id){

        return listarAmizadesService.listarAmizades(id);
    }

    @DeleteMapping("/amizade/{id}")
    public void removerAmizade(@PathVariable Long id){

        removerAmizadeService.remover(id);
    }

    @GetMapping("/amizade/solicitacoes/{id}")
    public List<SolicitacaoAmizadeResponse> listar(@PathVariable Long id){

        return listarSolicitacoesAmizadeService.listar(id);
    }

    @PostMapping("/amizade/solicitacoes/{id}")
    public AmizadeResponse aceitar(@PathVariable Long id){

        return aceitarSolicitacaoAmizadeService.aceitar(id);
    }

    @DeleteMapping("/amizade/solicitacoes/{id}")
    public void recusar(@PathVariable Long id){

        recusarSolicitacaoAmizadeService.recusar(id);
    }

    @PostMapping("/amizade/solicitacoes")
    public SolicitacaoAmizadeResponse solicitar(@Valid @RequestBody SolicitacaoAmizadeRequest request){

        return solicitarAmizadeService.solicitar(request);
    }

}

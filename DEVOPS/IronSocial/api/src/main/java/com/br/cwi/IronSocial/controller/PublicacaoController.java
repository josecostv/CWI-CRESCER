package com.br.cwi.IronSocial.controller;


import com.br.cwi.IronSocial.controller.request.PublicacaoComentadaRequest;
import com.br.cwi.IronSocial.controller.request.PublicacaoCurtidaRequest;
import com.br.cwi.IronSocial.controller.request.PublicacaoRequest;
import com.br.cwi.IronSocial.controller.response.PublicacaoComentadaResponse;
import com.br.cwi.IronSocial.controller.response.PublicacaoCurtidaResponse;
import com.br.cwi.IronSocial.controller.response.PublicacaoResponse;
import com.br.cwi.IronSocial.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    @Autowired
    private BuscarCurtidasService buscarCurtidasService;

    @Autowired
    private ListarComentariosPublicacaoService listarComentariosPublicacaoService;

    @Autowired
    private CurtirPublicacaoService curtirPublicacaoService;

    @Autowired
    private ComentarPublicacaoService comentarPublicacaoService;

    @Autowired
    private IncluirPublicacaoService incluirPublicacaoService;

    @Autowired
    private RemoverCurtidaPublicacaoService removerCurtidaPublicacaoService;

    @GetMapping("/{id}/curtidas")
    private List<PublicacaoCurtidaResponse> buscarCurtidas(@PathVariable Long id){

        return buscarCurtidasService.buscar(id);
    }

    @GetMapping("/{id}/comentarios")
    private List<PublicacaoComentadaResponse> listarComentarios(@PathVariable Long id){

        return listarComentariosPublicacaoService.listar(id);
    }

    @PostMapping("/curtir")
    public PublicacaoCurtidaResponse curtir(@Valid @RequestBody PublicacaoCurtidaRequest request){

        return curtirPublicacaoService.curtir(request);
    }

    @DeleteMapping("/descurtir")
    public void removerCurtida(@Valid @RequestBody PublicacaoCurtidaRequest request){

        removerCurtidaPublicacaoService.remover(request);
    }

    @PostMapping("/comentar")
    public PublicacaoComentadaResponse comentar(@Valid @RequestBody PublicacaoComentadaRequest request){

        return comentarPublicacaoService.comentar(request);
    }

    @PostMapping
    public PublicacaoResponse incluir(@Valid @RequestBody PublicacaoRequest request){

        return incluirPublicacaoService.incluir(request);
    }
}

package com.br.cwi.IronSocial.security.controller;

import com.br.cwi.IronSocial.security.controller.request.UsuarioRequest;
import com.br.cwi.IronSocial.security.controller.response.UsuarioResponse;
import com.br.cwi.IronSocial.security.service.IncluirUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService service;

    @PostMapping
    public UsuarioResponse incluir(@RequestBody UsuarioRequest request) {
        return service.incluir(request);
    }
}

package com.lucassilvs.javaspringwithsecretmanager.controller.impl;

import com.lucassilvs.javaspringwithsecretmanager.controller.UsuarioController;
import com.lucassilvs.javaspringwithsecretmanager.models.controller.response.UsuarioModelResponse;
import com.lucassilvs.javaspringwithsecretmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<UsuarioModelResponse> buscarUsuario(@RequestParam(name = "cpf"  )  String cpf) {
        try {
            UsuarioModelResponse usuarioModelResponse = usuarioService.buscarUsuario(cpf);
            return ResponseEntity.ok(usuarioModelResponse);
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }

    }
}

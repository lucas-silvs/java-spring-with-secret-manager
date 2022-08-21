package com.lucassilvs.javaspringwithsecretmanager.controller;

import com.lucassilvs.javaspringwithsecretmanager.models.controller.response.UsuarioModelResponse;
import org.springframework.http.ResponseEntity;

public interface UsuarioController {

    ResponseEntity<UsuarioModelResponse> buscarUsuario(String cpf);
}

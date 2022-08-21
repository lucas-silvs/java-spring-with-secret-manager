package com.lucassilvs.javaspringwithsecretmanager.service;

import com.lucassilvs.javaspringwithsecretmanager.models.controller.response.UsuarioModelResponse;

public interface UsuarioService {

    UsuarioModelResponse buscarUsuario(String cpf);
}

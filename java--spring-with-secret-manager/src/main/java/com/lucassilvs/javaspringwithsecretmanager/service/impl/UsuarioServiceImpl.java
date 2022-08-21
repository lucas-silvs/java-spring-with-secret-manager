package com.lucassilvs.javaspringwithsecretmanager.service.impl;

import com.lucassilvs.javaspringwithsecretmanager.gateway.UsuarioGateway;
import com.lucassilvs.javaspringwithsecretmanager.gateway.entities.UsuarioEntity;
import com.lucassilvs.javaspringwithsecretmanager.models.controller.response.UsuarioModelResponse;
import com.lucassilvs.javaspringwithsecretmanager.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioGateway usuarioGateway;

    public UsuarioServiceImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public UsuarioModelResponse buscarUsuario(String cpf) {
        UsuarioEntity usuarioEntity = usuarioGateway.buscarUsuario(cpf);
        return  new UsuarioModelResponse(usuarioEntity);
    }


}

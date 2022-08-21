package com.lucassilvs.javaspringwithsecretmanager.gateway.impl;

import com.lucassilvs.javaspringwithsecretmanager.exceptions.UserNotFoundException;
import com.lucassilvs.javaspringwithsecretmanager.gateway.UsuarioGateway;
import com.lucassilvs.javaspringwithsecretmanager.gateway.entities.UsuarioEntity;
import com.lucassilvs.javaspringwithsecretmanager.gateway.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioGatewayImpl implements UsuarioGateway {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity buscarUsuario(String cpf) {
        return Optional.ofNullable(usuarioRepository.findByCpf(cpf))
                .orElseThrow(UserNotFoundException::new);
    }
}

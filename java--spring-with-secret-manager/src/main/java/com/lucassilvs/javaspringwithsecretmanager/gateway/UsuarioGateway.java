package com.lucassilvs.javaspringwithsecretmanager.gateway;

import com.lucassilvs.javaspringwithsecretmanager.gateway.entities.UsuarioEntity;

public interface UsuarioGateway {

    UsuarioEntity buscarUsuario(String cpf);
}

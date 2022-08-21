package com.lucassilvs.javaspringwithsecretmanager.models.controller.response;

import com.lucassilvs.javaspringwithsecretmanager.gateway.entities.UsuarioEntity;

import java.util.Date;


public class UsuarioModelResponse {

    private final String nome;
    private final String cpf;
    private final String login;
    private final Date dataNascimento;

    public UsuarioModelResponse(String nome, String cpf, String login, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioModelResponse(UsuarioEntity usuarioEntity) {
        this.nome = usuarioEntity.getNome();
        this.cpf = usuarioEntity.getCpf();
        this.dataNascimento = usuarioEntity.getDataNascimento();
        this.login = usuarioEntity.getLogin();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
}

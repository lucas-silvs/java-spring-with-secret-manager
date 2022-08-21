package com.lucassilvs.javaspringwithsecretmanager.gateway.repository;

import com.lucassilvs.javaspringwithsecretmanager.gateway.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, String> {

    UsuarioEntity findByCpf(String cpf);
}

package com.site.walletwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.walletwise.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
package com.site.walletwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.site.walletwise.model.Transacoes;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
}
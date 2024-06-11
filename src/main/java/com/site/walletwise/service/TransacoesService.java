package com.site.walletwise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.walletwise.model.Transacoes;
import com.site.walletwise.repository.TransacoesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository transacoesRepository;

    public List<Transacoes> findAll() {
        return transacoesRepository.findAll();
    }

    public Optional<Transacoes> findById(Long id) {
        return transacoesRepository.findById(id);
    }

    public Transacoes save(Transacoes transacao) {
        return transacoesRepository.save(transacao);
    }

    public void deleteById(Long id) {
        transacoesRepository.deleteById(id);
    }
}
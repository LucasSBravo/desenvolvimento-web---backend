package com.site.walletwise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.site.walletwise.model.Transacoes;
import com.site.walletwise.service.TransacoesService;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @GetMapping
    public ResponseEntity<List<Transacoes>> getAllTransacoes() {
        List<Transacoes> transacoes = transacoesService.findAll();
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacoes> getTransacaoById(@PathVariable Long id) {
        Optional<Transacoes> transacao = transacoesService.findById(id);
        return transacao.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Transacoes> createTransacao(@RequestBody Transacoes transacao) {
        Transacoes createdTransacao = transacoesService.save(transacao);
        return new ResponseEntity<>(createdTransacao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacoes> updateTransacao(@PathVariable Long id, @RequestBody Transacoes transacao) {
        Optional<Transacoes> existingTransacao = transacoesService.findById(id);

        if (existingTransacao.isPresent()) {
            transacao.setId(id);
            Transacoes updatedTransacao = transacoesService.save(transacao);
            return new ResponseEntity<>(updatedTransacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long id) {
        Optional<Transacoes> transacao = transacoesService.findById(id);

        if (transacao.isPresent()) {
            transacoesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

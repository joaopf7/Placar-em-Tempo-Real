package com.exemplo.placar.service;

import com.exemplo.placar.domain.Jogo;
import com.exemplo.placar.domain.StatusJogo;
import com.exemplo.placar.repository.JogoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class JogoService {

    @Inject
    private JogoRepository repository;

    @Transactional
    public Jogo criar(Jogo jogo) {
        return repository.salvar(jogo);
    }

    public List<Jogo> listarTodos() {
        return repository.listarTodos();
    }

    public List<Jogo> listarPorStatus(String status) {
        return repository.listarPorStatus(status);
    }

    public Jogo buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    @Transactional
    public Jogo atualizarPlacar(Long id, Integer placarA, Integer placarB) {
        Jogo jogo = buscarPorId(id);

        if (jogo.getStatus() == StatusJogo.ENCERRADO) {
            throw new IllegalStateException("Jogo encerrado não pode ser alterado");
        }

        jogo.setPlacarA(placarA);
        jogo.setPlacarB(placarB);
        return repository.atualizar(jogo);
    }

    @Transactional
    public Jogo encerrar(Long id) {
        Jogo jogo = buscarPorId(id);
        jogo.setStatus(StatusJogo.ENCERRADO);
        return repository.atualizar(jogo);
    }
}

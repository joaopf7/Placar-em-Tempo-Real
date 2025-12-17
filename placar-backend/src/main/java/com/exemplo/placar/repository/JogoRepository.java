package com.exemplo.placar.repository;

import com.exemplo.placar.domain.Jogo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import jakarta.ejb.Stateless;

@Stateless
public class JogoRepository {

    @PersistenceContext(unitName = "placarPU")
    private EntityManager em;

    public Jogo salvar(Jogo jogo) {
        em.persist(jogo);
        return jogo;
    }

    public Jogo atualizar(Jogo jogo) {
        return em.merge(jogo);
    }

    public Optional<Jogo> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Jogo.class, id));
    }

    public List<Jogo> listarTodos() {
        return em.createQuery(
                "select j from Jogo j", Jogo.class
        ).getResultList();
    }

    public List<Jogo> listarPorStatus(String status) {
        return em.createQuery(
                "select j from Jogo j where j.status = :status", Jogo.class)
                .setParameter("status",
                        com.exemplo.placar.domain.StatusJogo.valueOf(status))
                .getResultList();
    }
}

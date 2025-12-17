package com.exemplo.placar.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timeA;
    private String timeB;

    private Integer placarA = 0;
    private Integer placarB = 0;

    @Enumerated(EnumType.STRING)
    private StatusJogo status = StatusJogo.EM_ANDAMENTO;

    private LocalDateTime dataHoraPartida;

    // getters e setters
    public Long getId() { return id; }

    public String getTimeA() { return timeA; }
    public void setTimeA(String timeA) { this.timeA = timeA; }

    public String getTimeB() { return timeB; }
    public void setTimeB(String timeB) { this.timeB = timeB; }

    public Integer getPlacarA() { return placarA; }
    public void setPlacarA(Integer placarA) { this.placarA = placarA; }

    public Integer getPlacarB() { return placarB; }
    public void setPlacarB(Integer placarB) { this.placarB = placarB; }

    public StatusJogo getStatus() { return status; }
    public void setStatus(StatusJogo status) { this.status = status; }

    public LocalDateTime getDataHoraPartida() { return dataHoraPartida; }
    public void setDataHoraPartida(LocalDateTime dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }
}

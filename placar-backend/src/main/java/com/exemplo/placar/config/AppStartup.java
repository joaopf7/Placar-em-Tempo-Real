package com.exemplo.placar.config;

import com.exemplo.placar.messaging.PlacarConsumer;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AppStartup {

    @PostConstruct
    public void init() {
        PlacarConsumer consumer = new PlacarConsumer();
        consumer.iniciarConsumer();
        System.out.println("Redis subscriber iniciado!");
    }
}

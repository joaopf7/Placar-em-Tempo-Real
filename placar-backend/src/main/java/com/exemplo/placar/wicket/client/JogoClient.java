package com.exemplo.placar.wicket.client;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import com.exemplo.placar.domain.Jogo;

public class JogoClient {

    private static final String BASE_URL =
            "http://localhost:8080/placar-backend/api/jogos";

    private final Client client = ClientBuilder.newClient();

    public List<Jogo> listar() {

        Response response = client
                .target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() != 200) {
            throw new RuntimeException(
                "Erro ao buscar jogos. HTTP " + response.getStatus()
            );
        }

        return response.readEntity(new GenericType<List<Jogo>>() {});
    }

    
}

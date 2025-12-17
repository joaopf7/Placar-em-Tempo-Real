package com.exemplo.placar.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/openapi")
public class OpenApiResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOpenApiJson() {
        return """
        {
  "openapi": "3.0.3",
  "info": {
    "title": "Placar API",
    "version": "1.0.0",
    "description": "API de exemplo para gerenciamento de jogos de futebol"
  },
  "servers": [
    {
      "url": "/placar-backend/api"
    }
  ],
  "paths": {
    "/jogos": {
      "get": {
        "summary": "Lista todos os jogos",
        "responses": {
          "200": {
            "description": "Lista de jogos",
            "content": {
              "application/json": {
                "example": [
                  {
                    "id": 1,
                    "timeA": "Brasil",
                    "timeB": "Argentina",
                    "placarA": 2,
                    "placarB": 1,
                    "dataHoraPartida": "2025-12-16T20:00:00",
                    "status": "ENCERRADO"
                  }
                ]
              }
            }
          }
        }
      },
      "post": {
        "summary": "Cria um novo jogo",
        "requestBody": {
          "required": true,
          "content": {
            "application/json": {
              "example": {
                "timeA": "Brasil",
                "timeB": "Argentina",
                "placarA": 0,
                "placarB": 0,
                "dataHoraPartida": "2025-12-20T18:00:00",
                "status": "EM_ANDAMENTO"
              }
            }
          }
        },
        "responses": {
          "201": {
            "description": "Jogo criado"
          }
        }
      }
    },
    "/jogos/{id}": {
      "get": {
        "summary": "Retorna um jogo pelo ID",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Jogo encontrado",
            "content": {
              "application/json": {
                "example": {
                  "id": 1,
                  "timeA": "Brasil",
                  "timeB": "Argentina",
                  "placarA": 2,
                  "placarB": 1,
                  "dataHoraPartida": "2025-12-16T20:00:00",
                  "status": "ENCERRADO"
                }
              }
            }
          },
          "404": {
            "description": "Jogo não encontrado"
          }
        }
      },
      "put": {
        "summary": "Encerra Partida",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer"
            }
          }
        ],
        "requestBody": {
          "required": true,
          "content": {
            "application/json": {
              "example": {
                "placarA": 3,
                "placarB": 2
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "Placar atualizado"
          },
          "404": {
            "description": "Jogo não encontrado"
          }
        }
      }
    },
    "/jogos/{id}/placar": {
      "put": {
        "summary": "Atualiza o placar de um jogo pelo ID",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer"
            }
          }
        ],
        "requestBody": {
          "required": true,
          "content": {
            "application/json": {
              "example": {
                "placarA": 3,
                "placarB": 2
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "Placar atualizado"
          },
          "404": {
            "description": "Jogo não encontrado"
          }
        }
      }
    }

  },
  "components": {
    "schemas": {
      "Jogo": {
        "type": "object",
        "properties": {
          "id": { "type": "integer" },
          "timeA": { "type": "string" },
          "timeB": { "type": "string" },
          "placarA": { "type": "integer" },
          "placarB": { "type": "integer" },
          "dataHoraPartida": { "type": "string", "format": "date-time" },
          "status": { "type": "string" }
        }
      }
    }
  }
}

        """;
    }
}

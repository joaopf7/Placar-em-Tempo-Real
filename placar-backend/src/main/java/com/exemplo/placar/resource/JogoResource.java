package com.exemplo.placar.resource;

import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.exemplo.placar.domain.Jogo;
import com.exemplo.placar.messaging.PlacarProducer;
import com.exemplo.placar.service.JogoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jogos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogoResource {

    @Inject
    private JogoService service;
    

    @POST
    @Operation(summary = "Cria um novo jogo")
    @APIResponse(responseCode = "201", description = "Criado")
    public Response criar(Jogo jogo) {
        return Response.status(Response.Status.CREATED)
                .entity(service.criar(jogo))
                .build();
    }

    @GET
    @Operation(summary = "Lista todos os jogos")
    @APIResponse(responseCode = "200", description = "Sucesso")
    public List<Jogo> listar(@QueryParam("status") String status) {
        if (status != null) {
            return service.listarPorStatus(status);
        }
        return service.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Jogo buscar(@PathParam("id") Long id) {
        return service.buscarPorId(id);
    }

    @PUT
    @Path("/{id}/placar")
    @Operation(summary = "Atualiza o placar do jogo")
    @APIResponse(responseCode = "200", description = "Atualizado")
    public Response atualizarPlacar(@PathParam("id") Long id,
                                Map<String, Integer> placar) {
        try {
            PlacarProducer placarProducer = new PlacarProducer();
            placarProducer.enviarAtualizacao("JOGO_ATUALIZADO:" + id);
            
            Jogo jogo = service.atualizarPlacar(
                id,
                placar.get("placarA"),
                placar.get("placarB"));
            
            
            return Response.status(Response.Status.OK)
                .entity(jogo)
                .build();
           
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        
    }

    @PUT
    @Path("/{id}")
    public Jogo encerrar(@PathParam("id") Long id) {
        return service.encerrar(id);
    }
}

package com.exemplo.placar.resource;

import com.exemplo.placar.realtime.SseBroadcasterService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.sse.Sse;
import jakarta.ws.rs.sse.SseEventSink;

@Path("/realtime")
public class RealtimeResource {

    @Inject
    private SseBroadcasterService broadcasterService;

    @GET
    @Produces("text/event-stream")
    public void connect(@Context Sse sse,
                        @Context SseEventSink sink) {

        broadcasterService.init(sse);
        broadcasterService.getBroadcaster().register(sink);
    }
}

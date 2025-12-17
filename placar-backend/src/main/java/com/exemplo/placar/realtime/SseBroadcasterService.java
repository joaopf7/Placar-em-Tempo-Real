package com.exemplo.placar.realtime;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.sse.Sse;
import jakarta.ws.rs.sse.SseBroadcaster;

@ApplicationScoped
public class SseBroadcasterService {

    private SseBroadcaster broadcaster;
    private Sse sse;

    public void init(Sse sse) {
        if (this.broadcaster == null) {
            this.sse = sse;
            this.broadcaster = sse.newBroadcaster();
        }
    }

    public void broadcast(String mensagem) {
        broadcaster.broadcast(
            sse.newEventBuilder()
               .name("placar")
               .data(String.class, mensagem)
               .build()
        );
    }

    public SseBroadcaster getBroadcaster() {
        return broadcaster;
    }
}

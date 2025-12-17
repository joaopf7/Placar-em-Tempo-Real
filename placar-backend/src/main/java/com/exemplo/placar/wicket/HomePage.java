package com.exemplo.placar.wicket;

import java.util.List;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.exemplo.placar.domain.Jogo;
import com.exemplo.placar.wicket.client.JogoClient;

public class HomePage extends WebPage {

    public HomePage() {

        JogoClient client = new JogoClient();
        List<Jogo> jogos = client.listar();

        add(new ListView<>("jogos", jogos) {

            @Override
            protected void populateItem(ListItem<Jogo> item) {
                Jogo jogo = item.getModelObject();

                item.add(new Label("timeA", jogo.getTimeA()));
                item.add(new Label("placarA", jogo.getPlacarA()));
                item.add(new Label("placarB", jogo.getPlacarB()));
                item.add(new Label("timeB", jogo.getTimeB()));
                item.add(new Label("status", jogo.getStatus()));
                

                
            }
        });
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(
            CssReferenceHeaderItem.forUrl("css/style.css")
        );
        response.render(
        JavaScriptHeaderItem.forScript(
            loadJs(),
            "placar-sse-inline"
        )
    );
    }

    private String loadJs() {
        return """
            const eventSource = new EventSource("/placar-backend/api/realtime");

            eventSource.addEventListener("placar", function (event) {
                const data = JSON.parse(event.data);

                atualizarTodos(".placarA", data.placarA);
                atualizarTodos(".placarB", data.placarB);
            });

            eventSource.onerror = () => {
                const status = document.getElementById("status-conexao");
                status.innerText = " Desconectado";
                status.classList.remove("online");
                status.classList.add("offline");
            };

            function atualizarTodos(selector, valor) {
                document.querySelectorAll(selector).forEach(el => {
                    el.innerText = valor;
                    el.classList.add("atualizado");

                    setTimeout(() => {
                        el.classList.remove("atualizado");
                    }, 300);
                });
            }
        """;
    }


}

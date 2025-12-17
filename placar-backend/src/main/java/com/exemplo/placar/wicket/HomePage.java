package com.exemplo.placar.wicket;

import java.util.List;

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
}

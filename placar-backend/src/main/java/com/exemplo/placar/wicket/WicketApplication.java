package com.exemplo.placar.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init() {
        super.init();

         // Configurações básicas
        getMarkupSettings().setStripWicketTags(true);

        // URL limpa
        mountPage("/placar", HomePage.class);
    }
}

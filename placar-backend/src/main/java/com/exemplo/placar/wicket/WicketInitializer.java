package com.exemplo.placar.wicket;

import org.apache.wicket.protocol.http.WicketFilter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WicketInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        ctx.setInitParameter(
            "wicket.configuration",
            "development"
        );

        ctx.setInitParameter(
            "applicationClassName",
            WicketApplication.class.getName()
        );

        ctx.setInitParameter(
            "filterMappingUrlPattern",
            "/wicket/*"
        );

        ctx.addFilter("wicket-filter", WicketFilter.class)
           .addMappingForUrlPatterns(null, false, "/wicket/*");
    }
}

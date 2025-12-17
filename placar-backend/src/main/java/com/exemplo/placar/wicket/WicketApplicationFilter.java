package com.exemplo.placar.wicket;

import org.apache.wicket.protocol.http.WicketFilter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(
    urlPatterns = "/wicket/*",
    initParams = {
        @WebInitParam(
            name = "applicationClassName",
            value = "com.exemplo.placar.wicket.WicketApplication"
        )
    }
)
public class WicketApplicationFilter extends WicketFilter {
}

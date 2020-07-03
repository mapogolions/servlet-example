package io.github.mapogolions.hook;

import io.github.mapogolions.config.ThymeleafConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ServletContextHook implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ThymeleafConfig.configureWith(event.getServletContext());
    }
}

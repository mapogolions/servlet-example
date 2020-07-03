package io.github.mapogolions.config;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;


public class ThymeleafConfig {
    public final static String VIEW_ENGINE = "org.thymeleaf.template.engine";

    public static void configureWith(ServletContext ctx) {
        ctx.setAttribute(VIEW_ENGINE, templateEngine(templateResolver(ctx)));
    }

    public static ITemplateResolver templateResolver(ServletContext ctx) {
        var resolver = new ServletContextTemplateResolver(ctx);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    public static ITemplateEngine templateEngine(ITemplateResolver resolver) {
        var engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        return engine;
    }
}

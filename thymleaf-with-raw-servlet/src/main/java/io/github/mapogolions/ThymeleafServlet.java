package io.github.mapogolions;

import io.github.mapogolions.config.ThymeleafConfig;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class ThymeleafServlet extends HttpServlet {
    public void view(String name, HttpServletRequest req, HttpServletResponse res) throws IOException {
        var ctx = req.getServletContext();
        var templateEngine = (ITemplateEngine) ctx.getAttribute(ThymeleafConfig.VIEW_ENGINE);
        templateEngine.process(name, new WebContext(req, res, ctx), res.getWriter());
    }
}

package io.github.mapogolions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/plain");
        try (var body = resp.getWriter()) {
            body.write("<h2>Welcome servlet</h2>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

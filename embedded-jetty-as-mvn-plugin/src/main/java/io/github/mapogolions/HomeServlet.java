package io.github.mapogolions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        var systemInfo = new SystemInfo();
        try (var body = resp.getWriter()) {
            body.write("<h2>Home page</h2>");
            systemInfo.dump(body);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

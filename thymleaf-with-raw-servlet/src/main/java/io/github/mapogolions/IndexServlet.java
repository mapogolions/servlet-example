package io.github.mapogolions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class IndexServlet extends ThymeleafServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setAttribute("title", "Index page");
        req.setAttribute("content", "Index page. Constructed with thymeleaf and server api");
        view("index.html", req, res);
    }
}

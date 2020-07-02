package io.github.mapogolions.middlewares;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogUriUrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        var req = (HttpServletRequest) servletRequest;
        var resp = (HttpServletResponse) servletResponse;
        System.out.println(String.format("Request URL: %s", req.getRequestURL().toString()));
        System.out.println(String.format("Request URI: %s", req.getRequestURI()));
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}


package com.speed.service;

import com.speed.model.SessionData;
import com.speed.model.UsersData;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Inject
    SessionData sessionData;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Optional<UsersData> user = sessionData.getUser();
        request.setAttribute("userdata", user.orElse(null));
        System.out.println("sessionData.getUser() = " + user.orElse(null));
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

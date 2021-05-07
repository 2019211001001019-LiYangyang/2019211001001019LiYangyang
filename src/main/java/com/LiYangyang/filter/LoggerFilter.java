package com.LiYangyang.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LoggerFilter",urlPatterns = "/hello")
public class LoggerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request come here - before go to servlet - doGet() or doPost()
        System.out.println("i am in LoggerFilter-->doFilter()- before servlet-(request come here");//when called?
        //request blocked after this filter
        chain.doFilter(request, response);//call next filter - if no next filter - then go to servlet
        //request after servlet come back here
        System.out.println("i am in LoggerFilter-->doFilter()- AFTER servlet-(response come here)");

    }
}

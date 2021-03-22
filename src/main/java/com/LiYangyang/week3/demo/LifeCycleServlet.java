package com.LiYangyang.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet", value = "/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
    //1.tomcat read wen.xml file and find out all servlet class
    //2.load servlet -when? 2.first request for this servlet come in - from client
    //3.call default constructor -add code
    public LifeCycleServlet(){
        System.out.println("i am in constructor -->LifeCycleServlet()");
    }
    //4.init()-add code
    public void init(){
        System.out.println("i am init()");
    }
    //5.tomcat call service()-->call doGet() or doPost

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy(){
        System.out.println("i am in destroy()");//
    }
}

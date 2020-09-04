package com.allsale.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class GenServlet extends GenericServlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("hello world");
        System.out.println();

        System.out.println("GenServlet.service");

        System.out.println("servletRequest = " + servletRequest + ", servletResponse = " + servletResponse);

        System.out.println("servletRequest = " + servletRequest);

    }
}

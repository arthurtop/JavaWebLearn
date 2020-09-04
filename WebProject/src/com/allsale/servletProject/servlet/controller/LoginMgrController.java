package com.allsale.servletProject.servlet.controller;

import com.allsale.servletProject.entity.Manager;
import com.allsale.servletProject.service.Impl.ManagerServiceImp;
import com.allsale.servletProject.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginMgrController",value = "/loginMgr")
public class LoginMgrController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset-utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ManagerService managerService = new ManagerServiceImp();
        Manager mgr = managerService.login(username,password);
        if (mgr != null){

            HttpSession session = request.getSession();
            session.setAttribute("mgr",mgr);

            response.sendRedirect("/WebProject_war_exploded/");


        }else {
            response.sendRedirect("/WebProject_war_exploded/loginMgr.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

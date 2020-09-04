package com.allsale.servletProject.servlet.controller;

import com.allsale.servletProject.entity.Admin;
import com.allsale.servletProject.entity.Manager;
import com.allsale.servletProject.service.AdminService;
import com.allsale.servletProject.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllController")
public class ShowAllAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Manager mgr = (Manager)session.getAttribute("mgr");
        if (mgr != null){
            AdminService  adminService = new AdminServiceImpl();
            List<Admin> adminList = adminService.showAllAdmin();

            request.setAttribute("admin",adminList);

            request.getRequestDispatcher("showalljsp").forward(request,response);
        }else {
            response.sendRedirect("/WebProject_war_exploded/login.html");
        }
    }
}

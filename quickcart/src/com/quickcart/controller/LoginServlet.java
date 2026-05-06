package com.quickcart.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("admin@quickcart.com") && password.equals("1234")) {
            response.sendRedirect("products");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
package com.javawebapp.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        String user = req.getParameter("userName");
        String pass = req.getParameter("userPassword");
        if (user.equals("admin") && pass.equals("password")) {
            RequestDispatcher rd = req.getRequestDispatcher("SampleServlet");
            rd.forward(req, resp);
        } else {
            pw.print("Sorry UserName or Password Error!");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        }
        pw.close();
    }
}

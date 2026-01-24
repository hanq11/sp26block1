package com.example.sd20308jav201.demoScope;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "demoScope2", value = {
        "/demo-scope-2"
})
public class DemoScope2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request scope
        String message = (String) req.getAttribute("demoRequestScope");
        System.out.println(message);

        // Session scope
        HttpSession session = req.getSession();
        String sessionMessage = (String) session.getAttribute("demoSessionScope");
        System.out.println(sessionMessage);

        // Application Scope
        ServletContext servletContext = getServletContext();
        String applicationMessage = (String) servletContext.getAttribute("demoApplicationScope");
        System.out.println(applicationMessage);

        req.getRequestDispatcher("/demoScope/hien-thi.jsp").forward(req, resp);
    }
}

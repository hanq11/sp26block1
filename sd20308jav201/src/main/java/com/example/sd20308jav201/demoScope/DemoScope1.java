package com.example.sd20308jav201.demoScope;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "demoScope1", value = {
        "/demo-scope-1"
})
public class DemoScope1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request scope
        String message = "From demo request scope";
        req.setAttribute("demoRequestScope", message);
        // Session scope
        String sessionMessage = "From demo session scope";
        HttpSession session = req.getSession();
        session.setAttribute("demoSessionScope", sessionMessage);
        // Application scope
        ServletContext servletContext = getServletContext();
        String applicationMessage = "FROM application scope";
        servletContext.setAttribute("demoApplicationScope", applicationMessage);

        req.getRequestDispatcher("/demo-scope-2").forward(req, resp);
    }
}

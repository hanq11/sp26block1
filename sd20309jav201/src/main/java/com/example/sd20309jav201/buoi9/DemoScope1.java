package com.example.sd20309jav201.buoi9;

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
        String requestMessage = "From request scope";
        req.setAttribute("requestMessage", requestMessage);

        // Session scope
        HttpSession session = req.getSession();
        String sessionMessage = "From session scope";
        session.setAttribute("sessionMessage", sessionMessage);

        // Application scope
        ServletContext servletContext = getServletContext();
        String applicationMessage = "From application scope";
        servletContext.setAttribute("applicationMessage", applicationMessage);

        req.getRequestDispatcher("/demo-scope-2").forward(req, resp);
    }
}

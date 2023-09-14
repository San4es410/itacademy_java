package by.itacademy.jd2.firstapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "AnyNames", urlPatterns = "/names")
public class AnyNames extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        Enumeration<String> parameters = req.getParameterNames();

        while (parameters.hasMoreElements()) {
            String param = parameters.nextElement();

            if (param.equals("name")) {
                writer.write(req.getParameter("name"));
            }
        }

    }
}

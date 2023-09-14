package by.itacademy.jd2.firstapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWithNameSurname", urlPatterns = "/hello1")
public class HelloWithNameSurname extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");

        PrintWriter writer = resp.getWriter();
        writer.write("Hello " + secondName + " " + firstName);
    }
}

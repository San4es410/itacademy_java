package by.itacademy.jd2.firstapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet(name = "ConsoleNameServlet", urlPatterns = "/hello_with_name")
public class ConsoleNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");
        String firstName = req.getParameter("firstname");
        String secondName = req.getParameter("secondname");


        PrintWriter writer = resp.getWriter();
        writer.write("Hello " + secondName + " " + firstName);
    }
}

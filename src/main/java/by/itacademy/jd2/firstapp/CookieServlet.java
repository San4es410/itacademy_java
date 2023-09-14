package by.itacademy.jd2.firstapp;

import jakarta.servlet.HttpConstraintElement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        Cookie cookieFirstName = new Cookie("fistName", firstName);
        Cookie cookieLastName = new Cookie("lastName", lastName);
        resp.addCookie(cookieFirstName);
        resp.addCookie(cookieLastName);

        PrintWriter writer = resp.getWriter();

        if (!(cookieFirstName.equals(null) && cookieLastName.equals(null))) {
            writer.write("Hello " + cookieLastName + " " + cookieFirstName);
        } else if (!(firstName.equals(null) && lastName.equals(null))) {
            writer.write("Hello " + lastName + " " + firstName );
        } else {
            writer.write("Какая-то фигня");
        }

    }
}

package by.itacademy.jd2.firstapp.ex_voiting;

import by.itacademy.jd2.firstapp.ex_voiting.support.AboutMyself;
import by.itacademy.jd2.firstapp.ex_voiting.support.Artist;
import by.itacademy.jd2.firstapp.ex_voiting.support.Genre;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class VoitingServlet extends HttpServlet {

    List<Artist> artistsList = new ArrayList<>();
    List<Genre> genresList = new ArrayList<>();
    List<AboutMyself> aboutMyselvesList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");

        String artist = req.getParameter("artist");
        String[] genre = req.getParameterValues("genre");
        String aboutMyself = req.getParameter("aboutMyself");

        PrintWriter writer = resp.getWriter();

        if (genre.length < 3 || genre.length > 5) {
            writer.write("Выберите необходимое количество жанров");
            IllegalArgumentException exception = new IllegalArgumentException();
            throw exception;
        }

        for (Artist art : artistsList) {
            if (art.getName().equals(artist)) {
                art.setNumberVotes(art.getNumberVotes());
            } else {
                artistsList.add(new Artist(artist));
            }
        }

        for (String s : genre) {
            for (Genre g : genresList) {
                if (g.getName().equals(s)) {
                    g.setNumberVotes(g.getNumberVotes());
                } else {
                    genresList.add(new Genre(s));
                }
            }
        }

        aboutMyselvesList.add(new AboutMyself(aboutMyself));

        artistsList.sort((a, b) -> b.getNumberVotes() - a.getNumberVotes());
        genresList.sort((a, b) -> b.getNumberVotes() - a.getNumberVotes());

        for (Artist art : artistsList) {
            writer.write(art.toString());
        }

        for (Genre gen : genresList) {
            writer.write(gen.toString());
        }

        for (AboutMyself about : aboutMyselvesList) {
            writer.write(about.toString());
        }
    }

}

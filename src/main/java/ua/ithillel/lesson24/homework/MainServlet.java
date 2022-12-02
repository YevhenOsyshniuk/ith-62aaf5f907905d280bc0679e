package ua.ithillel.lesson24.homework;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;


@WebServlet(name = "MainServlet", urlPatterns = "/hello")
public class MainServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        var writer = resp.getWriter();
        writer.println("Hello World");
        writer.close();
    }
}

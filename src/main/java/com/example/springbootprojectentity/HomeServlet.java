package com.example.springbootprojectentity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String res = "<div>\n" +
                "<form action=\"/login\" method=\"GET\">\n" +
                "Person Name: <input type = \"text\" name = \"name\"><br>\n" +
                "Person Email: <input type=\"text\" name=\"email\"><br>\n" +
                "<input type = \"submit\" value=\"Login\"><br>\n" +
                "</form>\n" +
                "</div>";
        String res1 = "<div>\n" +
                "<form action=\"/register\" method=\"POST\">\n" +
                "Person Name: <input type = \"text\" name = \"name\"><br>\n" +
                "Person Email: <input type=\"text\" name=\"email\"><br>\n" +
                "<input type = \"submit\" value=\"Register\"><br>\n" +
                "</form>\n" +
                "</div>";
        String res4 = "<div>\n" +
                "<form action=\"/showdetails\" method=\"GET\">\n" +
                "<input type = \"submit\" value=\"Show all the LoggedIn Students\"><br>\n" +
                "</form>\n" +
                "</div>";
        response.getWriter().println(res);
        response.getWriter().println(res1);
        response.getWriter().println(res4);
    }
}

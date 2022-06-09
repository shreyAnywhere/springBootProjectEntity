package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String res = "<div>\n" +
                "  <form action=\"/studentdetails\" method=\"POST\">\n" +
                "    Person Name: <input type = \"text\" name = \"name\"><br>\n" +
                "    Person Email: <input type=\"text\" name=\"email\"><br>\n" +
                "    <input type = \"submit\" value=\"Submit the form\"><br>\n" +
                "  </form>\n" +
                "</div>";
        response.getWriter().println(res);
    }
}

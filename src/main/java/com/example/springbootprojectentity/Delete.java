package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Entity entity = (Entity) session.getAttribute("entity");

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        datastore.delete(entity.getKey());

        response.getWriter().println("Your entity has been deleted...");
        response.sendRedirect("/");
    }
}

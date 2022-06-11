package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newName = request.getParameter("name");
        String newEmail = request.getParameter("email");
        HttpSession session = request.getSession();
        Entity entity = (Entity) session.getAttribute("entity");
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        entity = Entity.newBuilder(entity).set("name", newName).set("email", newEmail).build();
        datastore.update(entity);

        response.getWriter().println("your entity has been updated...");
    }
}

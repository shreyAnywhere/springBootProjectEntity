package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name  = request.getParameter("name");
        String email = request.getParameter("email");
        boolean f = false;

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query = Query.newEntityQueryBuilder()
                .setKind("StudentDetails")
                .build();
        QueryResults<Entity> results = datastore.run(query);

        while (results.hasNext()) {
            Entity entity = results.next();
            String name1 = entity.getString("name");
            String email1 = entity.getString("email");

            if(Objects.equals(name, name1) && Objects.equals(email, email1))
            {
                f = true;
                response.getWriter().println("You are logged in...");
                break;
            }
        }
        if(!f)
            response.getWriter().println("The student with entered name and email is not registered...");
    }
}

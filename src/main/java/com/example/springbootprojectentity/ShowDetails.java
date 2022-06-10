package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class ShowDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query = Query.newEntityQueryBuilder()
                .setKind("StudentDetails")
                .build();
        QueryResults<Entity> results = datastore.run(query);

        while (results.hasNext()) {
            Entity entity = results.next();
            String name = entity.getString("name");
            String email = entity.getString("email");
            if(Objects.equals(name, "shrey1"))
            {
                //entity = Entity.newBuilder(entity).set("name", "shrey3").build();
                //datastore.put(entity);
                datastore.delete(entity.getKey());
            }

            response.getWriter().println("<li>" + name + "</li>" + "<li>" + email + "</li>");
        }
        response.getWriter().println("Hello from showdetails servlet...");
    }
}

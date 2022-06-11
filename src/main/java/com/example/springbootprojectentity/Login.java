package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
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
                HttpSession session = request.getSession();
                session.setAttribute("entity", entity);
                String res = "<div>\n" +
                        "<form action=\"/update\" method=\"GET\">\n" +
                        "New Name: <input type = \"text\" name = \"name\"><br>\n" +
                        "New Email: <input type=\"text\" name=\"email\"><br>\n" +
                        "<input type = \"submit\" value=\"Update Entity\"><br>\n" +
                        "</form>\n" +
                        "</div>";
                String res2 = "<div>\n" +
                        "<form action=\"/delete\" method=\"GET\">\n" +
                        "<input type = \"submit\" value=\"Delete Entity\"><br>\n" +
                        "</form>\n" +
                        "</div>";
                response.getWriter().println(res);
                response.getWriter().println(res2);
                response.getWriter().println("You are logged in with " + name + " and " + email);
                break;
            }
        }
        if(!f)
            response.getWriter().println("The student with entered name and email is not registered...");
    }
}

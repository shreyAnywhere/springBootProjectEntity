package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Register extends HttpServlet {

    private long id = 0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name  = request.getParameter("name");
        String email = request.getParameter("email");

        if(name.equals("") || email.equals(""))
            response.getWriter().println("Either name or email is empty...");
        else
        {
            Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
            KeyFactory keyFactory = datastore.newKeyFactory().setKind("StudentDetails");
            FullEntity entity = Entity.newBuilder(keyFactory.newKey())
                    .set("name", name)
                    .set("email", email)
                    .build();
            datastore.put(entity);

            response.getWriter().println("The student details has been registered in datastore...");
        }
    }
}

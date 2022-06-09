package com.example.springbootprojectentity;

import com.google.cloud.datastore.*;
import com.google.cloud.spring.data.datastore.core.DatastoreTemplate;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
//        KeyFactory keyFactory = datastore.newKeyFactory().setKind("StudentDetails");
//        FullEntity entity = Entity.newBuilder(keyFactory.newKey())
//                        .set("name", "abc")
//                                .set("email", "abc@gmail.com")
//                                        .build();
//        datastore.put(entity);
        response.getWriter().println("The student details has been stored in datastore...");
    }
}

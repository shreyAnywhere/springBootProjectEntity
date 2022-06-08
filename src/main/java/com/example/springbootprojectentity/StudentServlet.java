package com.example.springbootprojectentity;

import com.google.cloud.spring.data.datastore.core.DatastoreTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StudentServlet extends HttpServlet {

    @Autowired
    DatastoreTemplate datastoreTemplate;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            StudentDetails studentDetails = new StudentDetails();
            studentDetails.setName("abc");
            studentDetails.setEmail("abc@gmail.com");
            studentDetails.setAge(30);

            datastoreTemplate.save(studentDetails);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        response.getWriter().println("Hello world from Student servlet of Entity project!!! Updated code!!!");
    }
}

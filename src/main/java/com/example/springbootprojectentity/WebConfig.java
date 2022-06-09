package com.example.springbootprojectentity;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> studentServlet() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new StudentServlet());
        servRegBean.addUrlMappings("/studentdetails");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }

    @Bean
    public ServletRegistrationBean<HttpServlet> htmlServlet() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new HtmlServlet());
        servRegBean.addUrlMappings("/");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }

    @Bean
    public ServletRegistrationBean<HttpServlet> showdetails() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new ShowDetails());
        servRegBean.addUrlMappings("/showdetails");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }
}

package com.community;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
public class SpringWebAppInitializer implements WebApplicationInitializer {
 
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
      AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
      appContext.register(ApplicationContextConfig.class);
 
      ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
              new DispatcherServlet(appContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("*.html");  // This extension is used for requesting Views.
      dispatcher.addMapping("*.json");  // This extension is used for REST requests producing JSON.
 
      dispatcher.setInitParameter("contextClass", appContext.getClass().getName());
 
      servletContext.addListener(new ContextLoaderListener(appContext));

 
  }
 
}
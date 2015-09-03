# poc-feature-toggle-cdi
This is a EJB Boot application using undertow servlet container and CDI. In addition to presenting a solution of feature toggle to enable or disable features by header in each HTTP request.
  
  Prerequisites:
  
    maven 3
    java 8


  To run:
  
    mvn clean install
    java -jar target/embedded-app/app.jar


  Test in your browser (feature toggle turn off by default):
    
    http://localhost:8080/my-app/api/test  


  Test in your terminal (feature toggle turn on by header parameter):
  
    curl -H "feature-enable-happy-message:true" http://localhost:8080/my-app/api/test

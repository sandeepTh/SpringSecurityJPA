package com.example.springsecurityjpa;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${spring.datasource.url}")
    private String dbConnection;

    @GetMapping(value = "/", produces = "application/xml")
    public String home(){
        return ("<h1>Welcome HOme</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome ADMIN</h1>");
    }

   @GetMapping("/db")
    public String getConnectionString(){
        return dbConnection;
    }
}

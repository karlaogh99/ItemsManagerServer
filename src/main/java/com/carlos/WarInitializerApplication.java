package com.carlos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WarInitializerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(WarInitializerApplication.class);
    }

    public static void main(String[] args) {
        try {
            SpringApplication sa = new SpringApplication(
                    WarInitializerApplication.class);
            sa.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RestController
    public static class WarInitializerController  {

        @GetMapping("/")
        public String handler() {
            // ...
            return "fgunjnj";
        }
    }
}
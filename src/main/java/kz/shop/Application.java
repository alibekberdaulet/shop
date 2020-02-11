package kz.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] arg) {
        ApplicationContext ctx = SpringApplication.run(Application.class, arg);
/*
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        System.out.println("\n\nSTART");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println("END\n\n");*/

    }
}

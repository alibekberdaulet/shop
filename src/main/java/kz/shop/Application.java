package kz.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] arg) {
        SpringApplication.run(Application.class, arg);
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

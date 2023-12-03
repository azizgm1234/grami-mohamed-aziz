package tn.esprit.se.projet1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

@EnableAspectJAutoProxy
public class Projet1Application {
	public static void main(String[] args) {
		SpringApplication.run(Projet1Application.class, args);
	}

}

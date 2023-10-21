package com.thinkconstructive.restdemo;

import com.thinkconstructive.restdemo.model.User;
import com.thinkconstructive.restdemo.persistence.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(UserRepository repository) {
		return (args) -> {
			tabulaRasaInsertTenEntries(repository);
			System.out.println(repository.findAll());
		};
	}

	private static void tabulaRasaInsertTenEntries(UserRepository repository) {
		repository.deleteAll();
		repository.save(new User("Dalia", "Müller","1234Ort","dalia@gmx.net"));
		repository.save(new User("Tomas", "Schmit","12345Ort","tomas@gmx.net"));
		repository.save(new User("Dieter", "Rinn","123456Ort","dieter@gmx.net"));
		repository.save(new User("Helwig", "Geiße","1234567Ort","helwig@gmx.net"));
		repository.save(new User("Just", "Geiße","12345678Ort","just@gmx.net"));
		repository.save(new User("Metz", "Müller","1234Ort","dalia@gmx.net"));
		repository.save(new User("Cemics", "Schmit","12345Ort","tomas@gmx.net"));
		repository.save(new User("Aris", "Christidis","123456Ort","dieter@gmx.net"));
		repository.save(new User("Bernd", "Recker","1234567Ort","helwig@gmx.net"));
		repository.save(new User("Just", "Geiße","12345678Ort","just@gmx.net"));
	}

}

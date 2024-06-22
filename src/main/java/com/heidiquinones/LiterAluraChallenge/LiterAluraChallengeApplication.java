package com.heidiquinones.LiterAluraChallenge;

import com.heidiquinones.LiterAluraChallenge.principal.Principal;
import com.heidiquinones.LiterAluraChallenge.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeApplication implements CommandLineRunner {
	@Autowired
	private LibrosRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Principal principal = new Principal(repository);
		//principal.muestraMenu();
	}
}

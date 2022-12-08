package com.sndi.springbootTraining;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sndi.springbootTraining.entities.Acheteur;
import com.sndi.springbootTraining.entities.Livreur;
import com.sndi.springbootTraining.entities.Role;
import com.sndi.springbootTraining.entities.User;
import com.sndi.springbootTraining.entities.Vendeur;
import com.sndi.springbootTraining.repositories.UserRepository;

@SpringBootApplication
public class SndiSpringTrainingApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SndiSpringTrainingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user;

		user =  new Vendeur();
		user.setPassword(UUID.randomUUID().toString());
		user.setUserName("IS Vendeur");
		/* user.setRoles(Set.of(Role.VENDEUR)); */
		repository.save(user);

		user =  new Livreur();
		user.setPassword(UUID.randomUUID().toString());
		user.setUserName("IS Livreur");
		/* user.setRoles(Set.of(Role.LIVREUR)); */
		repository.save(user);

		user =  new Acheteur();
		user.setPassword(UUID.randomUUID().toString());
		user.setUserName("IS Acheteur");
		/* user.setRoles(Set.of(Role.ACHETEUR)); */
		repository.save(user);
	}

}

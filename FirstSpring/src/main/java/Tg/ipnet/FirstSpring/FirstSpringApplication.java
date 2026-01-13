package Tg.ipnet.FirstSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import Tg.ipnet.FirstSpring.entity.Filiere;
import Tg.ipnet.FirstSpring.repository.FiliereRepository;

@SpringBootApplication
public class FirstSpringApplication  implements CommandLineRunner{
	
	@Autowired
	private FiliereRepository filiereRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
	}

}

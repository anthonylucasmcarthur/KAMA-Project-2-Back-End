package dev.KAMA.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dev.KAMA")
@EnableJpaRepositories("dev.KAMA.repositories")
@EntityScan("dev.KAMA.entities")
public class KamaProject2BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(KamaProject2BackEndApplication.class, args);
	}

}

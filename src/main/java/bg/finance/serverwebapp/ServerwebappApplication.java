package bg.finance.serverwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"bg.finance"})
@EnableJpaRepositories(basePackages = "bg.finance.repositories")
@EntityScan (basePackages = "bg.finance.models")
public class ServerwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerwebappApplication.class, args);
	}

}

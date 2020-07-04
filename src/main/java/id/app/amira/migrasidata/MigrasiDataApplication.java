package id.app.amira.migrasidata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MigrasiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MigrasiDataApplication.class, args);
	}

}
